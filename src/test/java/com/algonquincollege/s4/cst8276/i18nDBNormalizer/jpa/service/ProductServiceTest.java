package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.service;

import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.dto.ProductDetailDTO;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.*;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.repo.LanguageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 11:49 p.m.
 */
@SpringBootTest
class ProductServiceTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder cb;

    @Mock
    private CriteriaQuery<ProductDetailDTO> query;

    @Mock
    private Root<Product> product;

    @Mock
    private Join price;

    @Mock
    private Join currency;

    @Mock
    private Join translation;

    @Mock
    private Join language;

    @Mock
    private TypedQuery<ProductDetailDTO> typedQuery;

    @Mock
    private LanguageRepository languageRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock EntityManager behavior
        when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery(ProductDetailDTO.class)).thenReturn(query);
        when(query.from(Product.class)).thenReturn(product);
        when(product.join("prices")).thenReturn(price);
        when(price.join("currency")).thenReturn(currency);
        when(product.join("translations")).thenReturn(translation);
        when(translation.join("language")).thenReturn(language);
        when(entityManager.createQuery(query)).thenReturn(typedQuery);
    }

    @Test
    public void testGetProductDetails_WithCurrencyCode() {
        // Arrange
        String languageCode = "en";
        String currencyCode = "USD";

        // Mock query results
        ProductDetailDTO dto = new ProductDetailDTO(1, "Product1", "USD", "US Dollar", new BigDecimal(100.0), "Category1", "Product1 Name", "Description1", "en");
        List<ProductDetailDTO> expectedResults = Arrays.asList(dto);
        when(typedQuery.getResultList()).thenReturn(expectedResults);

        // Act
        List<ProductDetailDTO> results = productService.getProductDetails(languageCode, currencyCode);

        // Assert
        assertEquals(1, results.size());
        assertEquals("USD", results.get(0).getCurrencyCode());
        verify(typedQuery, times(1)).getResultList();
    }

    @Test
    public void testGetProductDetails_WithoutCurrencyCode() {
        // Arrange
        String languageCode = "en";
        String currencyCode = null;

        // Mock query results
        ProductDetailDTO dto = new ProductDetailDTO(1, "Product1", "EUR", "Euro", new BigDecimal(90.0), "Category2", "Product2 Name", "Description2", "en");
        List<ProductDetailDTO> expectedResults = Arrays.asList(dto);
        when(typedQuery.getResultList()).thenReturn(expectedResults);

        // Act
        List<ProductDetailDTO> results = productService.getProductDetails(languageCode, currencyCode);

        // Assert
        assertEquals(1, results.size());
        assertEquals("EUR", results.get(0).getCurrencyCode());
        verify(typedQuery, times(1)).getResultList();
    }

    @Test
    public void testLanguageList() {


        Language lang1 = new Language();
        lang1.setLanguageCode("en");
        lang1.setLanguageName("English");

        Language lang2 = new Language();
        lang2.setLanguageCode("fr");
        lang2.setLanguageName("French");

        Language lang3 = new Language();
        lang2.setLanguageCode("zh");
        lang2.setLanguageName("Chinese");

        List<Language> mockLanguages = Arrays.asList(lang1, lang2, lang3);

        when(languageRepository.findAll()).thenReturn(mockLanguages);

        List<Language> languages = productService.getLanguages();

        assertEquals(3, languages.size());

    }
}
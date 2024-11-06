package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.service;

import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.dto.ProductDetailDTO;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.*;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.repo.CurrencyRepository;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.repo.LanguageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 11:26 p.m.
 */
@Service
public class ProductService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<ProductDetailDTO> getProductDetails(String languageCode, String currencyCode) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductDetailDTO> query = cb.createQuery(ProductDetailDTO.class);

        // Define the roots for the query
        Root<Product> product = query.from(Product.class);
        Join<Product, ProductPrice> price = product.join("prices");
        Join<ProductPrice, Currency> currency = price.join("currency");
        Join<Product, ProductTranslation> translation = product.join("translations");
        Join<ProductTranslation, Language> language = translation.join("language");

        // Define the selection columns
        query.select(cb.construct(ProductDetailDTO.class,
                product.get("productId"),
                product.get("defaultName"),
                currency.get("currencyCode"),
                currency.get("currencyName"),
                price.get("price"),
                translation.get("category"),
                translation.get("productName"),
                translation.get("description"),
                language.get("languageCode")
        ));

        // Define the where clause with both languageCode and currencyCode conditions
        Predicate languagePredicate = cb.equal(language.get("languageCode"), languageCode);

        if (null != currencyCode && !currencyCode.isEmpty()) {
            Predicate currencyPredicate = cb.equal(currency.get("currencyCode"), currencyCode);
            query.where(cb.and(languagePredicate, currencyPredicate));
        } else {
            // Define the where clause
            query.where(cb.equal(language.get("languageCode"), languageCode));

        }
        TypedQuery<ProductDetailDTO> typedQuery = entityManager.createQuery(query);


        return typedQuery.getResultList();
    }

    public String buildSqlQueryString(String languageCode, String currencyCode) {
        StringBuilder sql = new StringBuilder("SELECT p.product_id, p.default_name, c.currency_code, c.currency_name,").append("\n");
        sql.append("pp.price, pt.category, pt.product_name, pt.description, l.language_code ").append("\n");
        sql.append("FROM products p ").append("\n");
        sql.append("JOIN product_prices pp ON p.product_id = pp.product_id ").append("\n");
        sql.append("JOIN currencies c ON pp.currency_code = c.currency_code ").append("\n");
        sql.append("JOIN product_translations pt ON p.product_id = pt.product_id ").append("\n");
        sql.append("JOIN languages l ON pt.language_code = l.language_code ").append("\n");
        sql.append("WHERE l.language_code = '").append(languageCode).append("' ").append("\n");

        if (currencyCode != null && !currencyCode.isEmpty()) {
            sql.append("AND c.currency_code = '").append(currencyCode).append("'");
        }

        return sql.toString();
    }


    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }
}

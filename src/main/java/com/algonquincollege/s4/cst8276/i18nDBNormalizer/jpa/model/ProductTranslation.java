package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model;

import jakarta.persistence.*;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 10:49 p.m.
 */
@Entity
@Table(name = "Product_Translations")
public class ProductTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translation_id")
    private Integer translationId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "language_code", nullable = false)
    private Language language;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    // Getters and Setters
    public Integer getTranslationId() { return translationId; }
    public void setTranslationId(Integer translationId) { this.translationId = translationId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Language getLanguage() { return language; }
    public void setLanguage(Language language) { this.language = language; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}

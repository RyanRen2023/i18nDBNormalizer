package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 10:41 p.m.
 */
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "default_name", nullable = false)
    private String defaultName;

    // One-to-Many relationship with ProductTranslations
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductTranslation> translations;

    // One-to-Many relationship with ProductPrices
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPrice> prices;

    // Getters and Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public List<ProductTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<ProductTranslation> translations) {
        this.translations = translations;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ProductPrice> prices) {
        this.prices = prices;
    }
}

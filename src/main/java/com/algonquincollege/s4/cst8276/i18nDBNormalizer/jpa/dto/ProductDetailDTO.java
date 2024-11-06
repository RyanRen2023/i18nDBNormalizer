package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.dto;

import java.math.BigDecimal;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 11:20 p.m.
 */
public class ProductDetailDTO {

    private Integer productId;
    private String defaultName;
    private String currencyCode;
    private String currencyName;
    private BigDecimal price;
    private String category;
    private String productName;
    private String description;
    private String languageCode;

    public ProductDetailDTO(Integer productId, String defaultName, String currencyCode, String currencyName, BigDecimal price, String category, String productName, String description, String languageCode) {
        this.productId = productId;
        this.defaultName = defaultName;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.price = price;
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.languageCode = languageCode;
    }

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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}

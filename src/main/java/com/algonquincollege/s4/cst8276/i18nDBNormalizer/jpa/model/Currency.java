package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 10:49 p.m.
 */
@Entity
@Table(name = "Currencies")
public class Currency {
    @Id
    @Column(name = "currency_code", length = 3)
    private String currencyCode;

    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    // One-to-Many relationship with ProductPrices
    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPrice> prices;

    // Getters and Setters
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

    public List<ProductPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ProductPrice> prices) {
        this.prices = prices;
    }
}

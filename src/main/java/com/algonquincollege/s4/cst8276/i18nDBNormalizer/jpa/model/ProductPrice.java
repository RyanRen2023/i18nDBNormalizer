package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 10:50 p.m.
 */

@Entity
@Table(name = "Product_Prices")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer priceId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "currency_code", nullable = false)
    private Currency currency;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    // Getters and Setters
    public Integer getPriceId() { return priceId; }
    public void setPriceId(Integer priceId) { this.priceId = priceId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Currency getCurrency() { return currency; }
    public void setCurrency(Currency currency) { this.currency = currency; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}

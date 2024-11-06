package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 10:48 p.m.
 */
@Entity
@Table(name = "Languages")
public class Language {
    @Id
    @Column(name = "language_code", length = 10)
    private String languageCode;

    @Column(name = "language_name", nullable = false)
    private String languageName;

    // One-to-Many relationship with ProductTranslations
    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductTranslation> translations;

    // Getters and Setters
    public String getLanguageCode() { return languageCode; }
    public void setLanguageCode(String languageCode) { this.languageCode = languageCode; }

    public String getLanguageName() { return languageName; }
    public void setLanguageName(String languageName) { this.languageName = languageName; }

    public List<ProductTranslation> getTranslations() { return translations; }
    public void setTranslations(List<ProductTranslation> translations) { this.translations = translations; }
}

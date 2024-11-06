package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.controller;

import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.dto.ProductDetailDTO;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.Currency;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.Language;
import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.List;
import java.util.Locale;

/**
 * @Author BiggestOcean
 * @Date 2024-11-06 - 12:03 a.m.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model, @RequestParam(required = true, defaultValue = "en") String lang,
                             @RequestParam(required = false, defaultValue = "") String currencyCode,
                             HttpSession session) {
        Locale locale = new Locale(lang);
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        List<Language> languages = productService.getLanguages();
        List<Currency> currencies = productService.getCurrencies();
        List<ProductDetailDTO> products = productService.getProductDetails(lang, currencyCode);
        String sqlQuery = productService.buildSqlQueryString(lang, currencyCode);
        model.addAttribute("languages",languages);
        model.addAttribute("currencies",currencies);
        model.addAttribute("products",products);
        model.addAttribute("selectedCurrencyCode",currencyCode);
        model.addAttribute("selectedLanguage",locale.getLanguage());
        model.addAttribute("sqlQuery", sqlQuery);

        return "product";  // return content.html
    }


}

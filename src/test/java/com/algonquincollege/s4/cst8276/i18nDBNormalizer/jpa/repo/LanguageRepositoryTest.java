package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.repo;

import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.Language;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author BiggestOcean
 * @Date 2024-11-06 - 12:25 a.m.
 */
@SpringBootTest
class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    private Language language;

    @Test
    public void testFindAll(){
        List<Language> languages = languageRepository.findAll();
        assertNotNull(languages);
        assertTrue(languages.size() > 0);
    }

}
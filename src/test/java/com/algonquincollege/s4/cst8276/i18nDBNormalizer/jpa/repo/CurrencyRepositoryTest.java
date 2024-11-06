package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.repo;

import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.Currency;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author BiggestOcean
 * @Date 2024-11-05 - 11:41 p.m.
 */
@SpringBootTest
class CurrencyRepositoryTest {

    @Autowired
    private CurrencyRepository currencyRepository;

    private Currency currency;



    @Test
    public void testSaveCurrency() {
        // 验证 currency 是否已成功保存
        Optional<Currency> foundCurrency = currencyRepository.findById("USD");
        Assertions.assertTrue(foundCurrency.isPresent());
        Assertions.assertEquals("US Dollar", foundCurrency.get().getCurrencyName());
    }

}
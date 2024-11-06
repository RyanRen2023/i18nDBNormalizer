package com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.repo;

import com.algonquincollege.s4.cst8276.i18nDBNormalizer.jpa.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
}
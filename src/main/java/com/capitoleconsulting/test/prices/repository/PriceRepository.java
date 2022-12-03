package com.capitoleconsulting.test.prices.repository;

import com.capitoleconsulting.test.prices.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByProductIdAndBrandId(long productId, long brandId);

}

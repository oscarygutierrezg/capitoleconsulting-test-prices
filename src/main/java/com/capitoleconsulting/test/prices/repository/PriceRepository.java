package com.capitoleconsulting.test.prices.repository;

import com.capitoleconsulting.test.prices.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(
            value = "SELECT p FROM Price p WHERE  :now BETWEEN p.startDate AND p.endDate" +
                    " AND p.productId = :productId"+
                    " AND p.brandId = :brandId"
    )
    List<Price> findPrices(LocalDateTime now, long productId, long brandId);

}

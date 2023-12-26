package com.capitoleconsulting.test.prices.infrastracture.repository;

import com.capitoleconsulting.test.prices.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataSqlPriceRepository extends JpaRepository<Price, Long> {


    @Query(
            value = "SELECT p FROM Price p WHERE  :now BETWEEN p.startDate AND p.endDate" +
                    " AND p.productId = :productId"+
                    " AND p.brandId = :brandId"
    )
    List<Price> findPrices(LocalDateTime now, long productId, long brandId);

}

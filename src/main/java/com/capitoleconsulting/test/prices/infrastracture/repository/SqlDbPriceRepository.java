package com.capitoleconsulting.test.prices.infrastracture.repository;

import com.capitoleconsulting.test.prices.domain.dto.PriceRequest;
import com.capitoleconsulting.test.prices.domain.repository.PriceRepository;
import com.capitoleconsulting.test.prices.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
@AllArgsConstructor
public class SqlDbPriceRepository implements PriceRepository {


    private final SpringDataSqlPriceRepository springDataSqlPriceRepository;

    @Override
    public List<Price> findPrices(PriceRequest priceRequest) {
        return springDataSqlPriceRepository.findPrices(priceRequest.getNow(),priceRequest.getProductId(),priceRequest.getBrandId());
    }
}

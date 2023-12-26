package com.capitoleconsulting.test.prices.domain.repository;

import com.capitoleconsulting.test.prices.domain.dto.PriceRequest;
import com.capitoleconsulting.test.prices.domain.model.Price;

import java.util.List;

public interface PriceRepository {

    List<Price> findPrices(PriceRequest priceRequest);
}

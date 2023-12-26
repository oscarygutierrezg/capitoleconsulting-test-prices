package com.capitoleconsulting.test.prices.domain.service;

import com.capitoleconsulting.test.prices.domain.dto.PriceDto;
import com.capitoleconsulting.test.prices.domain.dto.PriceRequest;


public interface PriceServiceUseCase {
	PriceDto find(PriceRequest priceRequest);
}

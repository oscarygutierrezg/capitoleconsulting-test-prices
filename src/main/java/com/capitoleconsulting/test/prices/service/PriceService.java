package com.capitoleconsulting.test.prices.service;

import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceRequest;


public interface PriceService {
	PriceDto find(PriceRequest priceRequest);
}

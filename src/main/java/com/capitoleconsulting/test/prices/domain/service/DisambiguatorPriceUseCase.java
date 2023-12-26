package com.capitoleconsulting.test.prices.domain.service;

import com.capitoleconsulting.test.prices.domain.dto.PriceDto;
import com.capitoleconsulting.test.prices.domain.model.Price;

import java.util.List;


public interface DisambiguatorPriceUseCase {
	PriceDto disambiguate(List<Price> prices);
}

package com.capitoleconsulting.test.prices.service;

import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.model.Price;

import java.util.List;


public interface DisambiguatorPriceService {
	PriceDto disambiguate(List<Price> prices);
}

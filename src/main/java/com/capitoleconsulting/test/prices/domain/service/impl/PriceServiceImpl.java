package com.capitoleconsulting.test.prices.domain.service.impl;

import com.capitoleconsulting.test.prices.domain.dto.PriceDto;
import com.capitoleconsulting.test.prices.domain.dto.PriceRequest;
import com.capitoleconsulting.test.prices.domain.model.Price;
import com.capitoleconsulting.test.prices.domain.repository.PriceRepository;
import com.capitoleconsulting.test.prices.domain.service.DisambiguatorPriceUseCase;
import com.capitoleconsulting.test.prices.domain.service.PriceServiceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceServiceUseCase {

    private DisambiguatorPriceUseCase disambiguatorPriceService;
    private PriceRepository priceRepository;

    @Override
    public PriceDto find(PriceRequest priceRequest) {
        List<Price> prices = priceRepository.findPrices(priceRequest);
        return disambiguatorPriceService.disambiguate(prices);
    }
}

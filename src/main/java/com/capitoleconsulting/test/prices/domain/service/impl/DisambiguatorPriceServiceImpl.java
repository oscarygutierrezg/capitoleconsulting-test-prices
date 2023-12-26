package com.capitoleconsulting.test.prices.domain.service.impl;

import com.capitoleconsulting.test.prices.domain.dto.PriceDto;
import com.capitoleconsulting.test.prices.domain.dto.PriceMapper;
import com.capitoleconsulting.test.prices.domain.model.Price;
import com.capitoleconsulting.test.prices.domain.service.DisambiguatorPriceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DisambiguatorPriceServiceImpl implements DisambiguatorPriceUseCase {

    private PriceMapper priceMapper;

    @Override
    public PriceDto disambiguate(List<Price> prices) {
        return  prices
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .map(priceMapper::toDto)
                .orElseThrow(NoSuchElementException::new);
    }
}

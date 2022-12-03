package com.capitoleconsulting.test.prices.service.impl;

import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceMapper;
import com.capitoleconsulting.test.prices.model.Price;
import com.capitoleconsulting.test.prices.service.DisambiguatorPriceService;
import com.capitoleconsulting.test.prices.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DisambiguatorPriceServiceImpl implements DisambiguatorPriceService {

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

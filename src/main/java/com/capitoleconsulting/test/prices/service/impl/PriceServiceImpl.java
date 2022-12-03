package com.capitoleconsulting.test.prices.service.impl;

import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceRequest;
import com.capitoleconsulting.test.prices.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {
    @Override
    public PriceDto find(PriceRequest priceRequest) {
        return null;
    }
}

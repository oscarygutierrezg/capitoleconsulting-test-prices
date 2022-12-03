package com.capitoleconsulting.test.prices.service.impl;

import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceMapper;
import com.capitoleconsulting.test.prices.dto.PriceRequest;
import com.capitoleconsulting.test.prices.model.Price;
import com.capitoleconsulting.test.prices.repository.PriceRepository;
import com.capitoleconsulting.test.prices.service.DisambiguatorPriceService;
import com.capitoleconsulting.test.prices.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private DisambiguatorPriceService disambiguatorPriceService;
    private PriceRepository priceRepository;

    @Override
    public PriceDto find(PriceRequest priceRequest) {
        List<Price> prices = priceRepository.findPrices(priceRequest.getNow(),priceRequest.getProductId(),priceRequest.getBrandId());
        if(prices.isEmpty()){
            throw  new NoSuchElementException();
        }
        return disambiguatorPriceService.disambiguate(prices);
    }
}

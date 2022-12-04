package com.capitoleconsulting.test.prices.controller.impl;

import com.capitoleconsulting.test.prices.controller.PriceController;
import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceRequest;
import com.capitoleconsulting.test.prices.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class PriceControllerImpl implements PriceController {

    private final PriceService priceService;

    @Override
    public ResponseEntity<PriceDto> finrCurrentPrice(Long productId, Long brandId, LocalDateTime now) {
        return new ResponseEntity<>(priceService.find(
                PriceRequest.builder().now(now).brandId(brandId).productId(productId).build()
        ), HttpStatus.OK);

    }
}

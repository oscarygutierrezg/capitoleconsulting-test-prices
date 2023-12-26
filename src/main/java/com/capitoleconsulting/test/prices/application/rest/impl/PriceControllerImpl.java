package com.capitoleconsulting.test.prices.application.rest.impl;

import com.capitoleconsulting.test.prices.application.rest.PriceController;
import com.capitoleconsulting.test.prices.domain.dto.PriceDto;
import com.capitoleconsulting.test.prices.domain.dto.PriceRequest;
import com.capitoleconsulting.test.prices.domain.service.PriceServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class PriceControllerImpl implements PriceController {

    private final PriceServiceUseCase priceService;

    @Override
    public ResponseEntity<PriceDto> finrCurrentPrice(Long productId, Long brandId, LocalDateTime now) {
        return new ResponseEntity<>(priceService.find(
                PriceRequest.builder().now(now).brandId(brandId).productId(productId).build()
        ), HttpStatus.OK);

    }
}

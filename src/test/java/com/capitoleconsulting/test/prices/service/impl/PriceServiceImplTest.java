package com.capitoleconsulting.test.prices.service.impl;


import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceMapper;
import com.capitoleconsulting.test.prices.dto.PriceRequest;
import com.capitoleconsulting.test.prices.model.Price;
import com.capitoleconsulting.test.prices.repository.PriceRepository;
import com.capitoleconsulting.test.prices.service.DisambiguatorPriceService;
import com.capitoleconsulting.test.prices.util.PriceUtil;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;


@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

	@InjectMocks
	private PriceServiceImpl priceService;

	@Mock
	private DisambiguatorPriceService disambiguatorPriceService;
	@Mock
	private PriceRepository priceRepository;

	private final PriceUtil priceUtil = new PriceUtil();
	private Faker faker = new Faker();

	@Test
	public void test_Disambiguate_Should_ReturnPriceDto_When_Invoked() {
		Mockito.when(priceRepository.findPrices(Mockito.any(LocalDateTime.class), Mockito.anyLong(), Mockito.anyLong())).thenReturn(List.of(
				priceUtil.createPrice(),
				priceUtil.createPrice(),
				priceUtil.createPrice()));
		Mockito.when(disambiguatorPriceService.disambiguate(Mockito.any(List.class))).thenReturn(priceUtil.toDto(priceUtil.createPrice()));

		PriceDto priceDto = priceService.find(PriceRequest.builder().now(LocalDateTime.now())
				.brandId(faker.number().randomNumber())
				.productId(faker.number().randomNumber())
				.build());

		Assertions.assertNotNull(priceDto);
		Assertions.assertNotNull(priceDto.getStartDate());

		Mockito.verify(priceRepository, Mockito.times(1)).findPrices(Mockito.any(LocalDateTime.class), Mockito.anyLong(), Mockito.anyLong());
		Mockito.verify(disambiguatorPriceService, Mockito.times(1)).disambiguate(Mockito.any());
	}





}

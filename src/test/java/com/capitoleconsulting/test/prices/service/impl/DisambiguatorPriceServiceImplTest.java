package com.capitoleconsulting.test.prices.service.impl;


import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.capitoleconsulting.test.prices.dto.PriceMapper;
import com.capitoleconsulting.test.prices.model.Price;
import com.capitoleconsulting.test.prices.util.PriceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;


@ExtendWith(MockitoExtension.class)
public class DisambiguatorPriceServiceImplTest {

	@InjectMocks
	private DisambiguatorPriceServiceImpl disambiguatorPriceService;

	@Spy
	private PriceMapper priceMapper;

	private final PriceUtil priceUtil = new PriceUtil();
	

	@Test
	public void test_Disambiguate_Should_ReturnPriceDto_When_Invoked() {
		Mockito.when(priceMapper.toDto(Mockito.any(Price.class))).thenAnswer(p -> priceUtil.toDto((Price) p.getArguments()[0]));

		List<Price> prices = List.of(
				priceUtil.createPrice(),
				priceUtil.createPrice(),
				priceUtil.createPrice());
		
		PriceDto priceDto = disambiguatorPriceService.disambiguate(prices);

		Assertions.assertNotNull(priceDto);
		Assertions.assertNotNull(priceDto.getStartDate());

		Mockito.verify(priceMapper, Mockito.times(1)).toDto(Mockito.any());
	}


	@Test
	public void test_Disambiguate_Should_ReturnPriceDto_WithMajorPriority_When_Invoked() {
		Mockito.when(priceMapper.toDto(Mockito.any(Price.class))).thenAnswer(p -> priceUtil.toDto((Price) p.getArguments()[0]));

		Price priceCurrent = priceUtil.createPrice();
		Price priceNot = priceUtil.createPrice();

		priceNot.setPriority(0);
		priceCurrent.setPriority(1);


		List<Price> prices =List.of(
				priceNot,
				priceCurrent);

		PriceDto priceDto = disambiguatorPriceService.disambiguate(prices);

		Assertions.assertNotNull(priceDto);
		Assertions.assertNotNull(priceDto.getStartDate());
		Assertions.assertEquals(priceDto.getAmount(),priceCurrent.getAmount());

		Mockito.verify(priceMapper, Mockito.times(1)).toDto(Mockito.any());
	}

	@Test
	public void test_Show_Should_ReturnNoSuchElementExceptionWhen_Invoked() {
		NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
			disambiguatorPriceService.disambiguate(List.of());
		});

		Assertions.assertNotNull(exception);
	}





}

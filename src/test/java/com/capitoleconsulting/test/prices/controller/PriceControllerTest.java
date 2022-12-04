package com.capitoleconsulting.test.prices.controller;

import com.capitoleconsulting.test.prices.PricesApplication;
import com.capitoleconsulting.test.prices.dto.PriceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PricesApplication.class)
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith14T10_Invoked() throws JsonProcessingException, Exception {

		ResultActions res = mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&now=2020-06-14T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(1,priceDto.getPriceList());
		Assertions.assertEquals(35.50,priceDto.getAmount());

	}

	@Test
	public void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith14T16_Invoked() throws JsonProcessingException, Exception {

		ResultActions res =    mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&now=2020-06-14T16:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(2,priceDto.getPriceList());
		Assertions.assertEquals(25.45,priceDto.getAmount());

	}


	@Test
	public void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith14T21_Invoked() throws JsonProcessingException, Exception {

		ResultActions res =    mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&now=2020-06-14T21:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(1,priceDto.getPriceList());
		Assertions.assertEquals(35.50,priceDto.getAmount());

	}

	@Test
	public void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith15T10_Invoked() throws JsonProcessingException, Exception {

		ResultActions res = mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&now=2020-06-15T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(3,priceDto.getPriceList());
		Assertions.assertEquals(30.50,priceDto.getAmount());
	}

	@Test
	public void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith16T21_Invoked() throws JsonProcessingException, Exception {

		ResultActions res =    mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&now=2020-06-16T21:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(4,priceDto.getPriceList());
		Assertions.assertEquals(38.95,priceDto.getAmount());
	}


}



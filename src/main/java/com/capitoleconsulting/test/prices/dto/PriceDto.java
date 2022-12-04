package com.capitoleconsulting.test.prices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

	private long priceList;
	private long productId;
	private long brandId;
	private long priority;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String curr;
	private double amount;
}

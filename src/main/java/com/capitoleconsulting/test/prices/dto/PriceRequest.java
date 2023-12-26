package com.capitoleconsulting.test.prices.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PriceRequest {
	private LocalDateTime now;
	protected long productId;
	protected long brandId;
}

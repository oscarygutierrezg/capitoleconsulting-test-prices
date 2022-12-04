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
public class PriceRequest {
	private LocalDateTime now;
	protected long productId;
	protected long brandId;
}

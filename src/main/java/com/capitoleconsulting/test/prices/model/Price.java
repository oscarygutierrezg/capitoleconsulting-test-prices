package com.capitoleconsulting.test.prices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "price")

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

	@Id
	@Column(name = "PRICE_LIST")
	private long priceList;
	@Column(name = "PRODUCT_ID")
	private long productId;
	@Column(name = "BRAND_ID")
	private long brandId;
	@Column(name = "PRIORITY")
	private long priority;
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	@Column(name = "CURR")
	private String curr;

}

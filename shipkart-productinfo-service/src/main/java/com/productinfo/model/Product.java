package com.productinfo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

	@EqualsAndHashCode.Include
	private Integer productId;

	private String productName;

	private double price;

	private double rating;

	private Feature feature;

	private List<Offer> offers;

	private List<Category> categories;

	private Brand brand;

	private List<String> deliveryTypes; // PRIME, STANDARD, AMAZON

	private List<String> paymentModes; // CARD, UPI, NB, COD

}

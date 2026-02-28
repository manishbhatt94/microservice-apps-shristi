package com.productinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.productinfo.exception.ProductNotFoundException;
import com.productinfo.model.Product;
import com.productinfo.model.enums.Delivery;
import com.productinfo.model.enums.OfferType;
import com.productinfo.model.enums.Payment;
import com.productinfo.service.IProductInfoService;

@Service
public class ProductInfoServiceRestClientImpl implements IProductInfoService {

	private final RestClient restClient;

	// Use @Qualifier to specify the LoadBalanced version
	public ProductInfoServiceRestClientImpl(@Qualifier("loadBalancedRestClientBuilder") RestClient.Builder builder) {
		// Now 'builder' is the one with the LoadBalancer intercepter.
		// The service name 'product-catalog' is used as the base URL.
		this.restClient = builder.baseUrl("http://product-catalog/catalog-service/v1").build();
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		return restClient
				.get()
				.uri("/products/productId/{productId}", productId)
				.retrieve()
				.body(Product.class);
	}

	@Override
	public List<Product> getAll() {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		return restClient
				.get()
				.uri("/products")
				.retrieve()
				.body(bodyType);
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri("/products/category?categoryname={category}", category)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

	@Override
	public List<Product> getByBrandAndPayType(String brand, Payment paymentType) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri("/products/brand/{brand}/payment/{payment}", brand, paymentType)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

	@Override
	public List<Product> getByColor(String color) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri("/products/color/{color}", color)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

	@Override
	public List<Product> getByCategoryAndDelivery(String category, Delivery delivery) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri("/products/category/{category}/delivery/{delivery}", category, delivery)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

	@Override
	public List<Product> getByNameContains(String name) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri("/products/name/{name}", name)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

	@Override
	public List<Product> getByNameAndOfferType(String name, OfferType offerType) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri("/products/name/{name}/offer/{offer}", name, offerType)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

}

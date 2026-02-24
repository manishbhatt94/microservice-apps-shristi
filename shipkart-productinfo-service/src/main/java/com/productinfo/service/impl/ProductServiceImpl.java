package com.productinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.productinfo.exception.ProductNotFoundException;
import com.productinfo.model.Product;
import com.productinfo.model.enums.Delivery;
import com.productinfo.model.enums.OfferType;
import com.productinfo.model.enums.Payment;
import com.productinfo.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private RestClient restClient;

	private String BASE_URI = "http://product-catalog/product-api/v1";

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		return restClient
				.get()
				.uri(BASE_URI.concat("/products/productId/{productId}"), productId)
				.retrieve()
				.body(Product.class);
	}

	@Override
	public List<Product> getAll() {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		return restClient
				.get()
				.uri(BASE_URI.concat("/products"))
				.retrieve()
				.body(bodyType);
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		ParameterizedTypeReference<List<Product>> bodyType = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> response = restClient
				.get()
				.uri(BASE_URI.concat("/products/category?categoryname={category}"), category)
				.retrieve()
				.toEntity(bodyType);
		return response.getBody();
	}

	@Override
	public List<Product> getByBrandAndPayType(String brand, Payment paymentType) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByColor(String color) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategoryAndDelivery(String category, Delivery delivery) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameContains(String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameAndOfferType(String name, OfferType offerType) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

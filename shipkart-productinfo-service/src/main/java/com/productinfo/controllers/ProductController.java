package com.productinfo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productinfo.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productinfo-api/v1")
@RequiredArgsConstructor
public class ProductController {

	private final IProductService productService;

}

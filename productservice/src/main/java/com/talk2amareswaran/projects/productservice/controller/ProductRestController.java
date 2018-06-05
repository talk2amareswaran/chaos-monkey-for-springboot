package com.talk2amareswaran.projects.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talk2amareswaran.projects.productservice.model.Product;

@RestController
public class ProductRestController {

	List<Product> productsList = new ArrayList<>();
	
	
	@PostConstruct
	public void initiateProducts() {
		Product product1 = new Product();
		product1.setAvailableQty(56);
		product1.setId(67);
		product1.setPrice(5670.00d);
		product1.setProductName("Nokia Mobile");
		product1.setProductSKU("MOB-NK-009");
		productsList.add(product1);
		Product product2 = new Product();
		product2.setAvailableQty(12);
		product2.setId(78);
		product2.setPrice(18000.00d);
		product2.setProductName("One-Plus Mobile");
		product2.setProductSKU("MOB-ONEPLUS-001");
		productsList.add(product2);
	}
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(productsList, HttpStatus.OK);
	}
}

package com.talk2amareswaran.projects.gatewayservice.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.talk2amareswaran.projects.gatewayservice.commands.ProductServiceHystrixCommand;
import com.talk2amareswaran.projects.gatewayservice.commands.TelephoneServiceHystrixCommand;
import com.talk2amareswaran.projects.gatewayservice.commands.UserServiceHystrixCommand;
import com.talk2amareswaran.projects.gatewayservice.model.ApiResponse;
import com.talk2amareswaran.projects.gatewayservice.model.StartModel;

@RestController
public class GatewayRestController {

	RestTemplate restTemplate;
	
	@PostConstruct
	public void initiate() {
		restTemplate = new RestTemplate();
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ResponseEntity<Object> start() throws InterruptedException, ExecutionException {

		long start = System.currentTimeMillis();
		StartModel startModel = new StartModel();

		Future<ApiResponse> userServiceResponse = getUserService();
		Future<ApiResponse> productServiceResponse = getProductService();
		Future<ApiResponse> telephoneServiceResponse = getTelephoneService();

		startModel.setUserServiceResponse(extractData(userServiceResponse));
		startModel.setProductServiceResponse(extractData(productServiceResponse));
		startModel.setTelephoneServiceResponse(extractData(telephoneServiceResponse));

		startModel.setDuration(System.currentTimeMillis() - start);
		return new ResponseEntity<>(startModel, HttpStatus.OK);
	}

	private ApiResponse extractData(Future<ApiResponse> apiResponse) throws InterruptedException, ExecutionException {
		return apiResponse.get();
	}

	private Future<ApiResponse> getTelephoneService() {
		return new TelephoneServiceHystrixCommand(HystrixCommandGroupKey.Factory.asKey("telephoneservice"), 3000, restTemplate, "http://localhost:4433/telephoneservice/numbers").queue();
	}

	private Future<ApiResponse> getProductService() {
		return new ProductServiceHystrixCommand(HystrixCommandGroupKey.Factory.asKey("productservice"), 3000, restTemplate, "http://localhost:4432/productservice/products").queue();
	}

	private Future<ApiResponse> getUserService() {
		return new UserServiceHystrixCommand(HystrixCommandGroupKey.Factory.asKey("userservice"), 3000, restTemplate, "http://localhost:4431/userservice/users").queue();
	}

}

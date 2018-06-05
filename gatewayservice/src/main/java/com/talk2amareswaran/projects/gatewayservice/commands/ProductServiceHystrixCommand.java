package com.talk2amareswaran.projects.gatewayservice.commands;

import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.talk2amareswaran.projects.gatewayservice.model.ApiResponse;

public class ProductServiceHystrixCommand extends HystrixCommand<ApiResponse> {

	private final RestTemplate restTemplate;
	private final String url;

	public ProductServiceHystrixCommand(HystrixCommandGroupKey group, int timeout, RestTemplate restTemplate, String url) {
		super(group, timeout);
		this.restTemplate = restTemplate;
		this.url = url;
	}

	protected ApiResponse run() throws Exception {
		ApiResponse response = new ApiResponse();
		response.setApiResponseObject(Arrays.asList(restTemplate.getForObject(url, Object.class)));
		response.setResponseType("REMOTE");
		return response;
	}

	@Override
	protected ApiResponse getFallback() {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponseType("FALLBACK");
		return apiResponse;
	}

}

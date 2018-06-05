package com.talk2amareswaran.projects.gatewayservice.model;

import java.util.List;

public class ApiResponse {

	private List<Object> apiResponseObject;
	private String responseType;

	public List<Object> getApiResponseObject() {
		return apiResponseObject;
	}

	public void setApiResponseObject(List<Object> apiResponseObject) {
		this.apiResponseObject = apiResponseObject;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

}

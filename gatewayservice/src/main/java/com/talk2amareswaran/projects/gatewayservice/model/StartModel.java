package com.talk2amareswaran.projects.gatewayservice.model;

public class StartModel {

	private long duration;
	private ApiResponse userServiceResponse;
	private ApiResponse productServiceResponse;
	private ApiResponse telephoneServiceResponse;

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public ApiResponse getUserServiceResponse() {
		return userServiceResponse;
	}

	public void setUserServiceResponse(ApiResponse userServiceResponse) {
		this.userServiceResponse = userServiceResponse;
	}

	public ApiResponse getProductServiceResponse() {
		return productServiceResponse;
	}

	public void setProductServiceResponse(ApiResponse productServiceResponse) {
		this.productServiceResponse = productServiceResponse;
	}

	public ApiResponse getTelephoneServiceResponse() {
		return telephoneServiceResponse;
	}

	public void setTelephoneServiceResponse(ApiResponse telephoneServiceResponse) {
		this.telephoneServiceResponse = telephoneServiceResponse;
	}

}

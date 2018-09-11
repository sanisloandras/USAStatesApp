package com.sanislo.soft.usastatesapp.data.response;

import com.google.gson.annotations.SerializedName;

public class StatesResponse{

	@SerializedName("RestResponse")
	private RestResponse restResponse;

	public void setRestResponse(RestResponse restResponse){
		this.restResponse = restResponse;
	}

	public RestResponse getRestResponse(){
		return restResponse;
	}

	@Override
 	public String toString(){
		return 
			"StatesResponse{" + 
			"restResponse = '" + restResponse + '\'' + 
			"}";
		}
}
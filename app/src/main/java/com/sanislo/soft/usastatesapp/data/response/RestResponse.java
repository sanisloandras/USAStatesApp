package com.sanislo.soft.usastatesapp.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("messages")
	private List<String> messages;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setMessages(List<String> messages){
		this.messages = messages;
	}

	public List<String> getMessages(){
		return messages;
	}

	@Override
 	public String toString(){
		return 
			"RestResponse{" + 
			"result = '" + result + '\'' + 
			",messages = '" + messages + '\'' + 
			"}";
		}
}
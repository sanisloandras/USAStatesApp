package com.sanislo.soft.usastatesapp.data.response;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("area")
	private String area;

	@SerializedName("country")
	private String country;

	@SerializedName("capital")
	private String capital;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("abbr")
	private String abbr;

	@SerializedName("largest_city")
	private String largestCity;

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return area;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCapital(String capital){
		this.capital = capital;
	}

	public String getCapital(){
		return capital;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAbbr(String abbr){
		this.abbr = abbr;
	}

	public String getAbbr(){
		return abbr;
	}

	public void setLargestCity(String largestCity){
		this.largestCity = largestCity;
	}

	public String getLargestCity(){
		return largestCity;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"area = '" + area + '\'' + 
			",country = '" + country + '\'' + 
			",capital = '" + capital + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",abbr = '" + abbr + '\'' + 
			",largest_city = '" + largestCity + '\'' + 
			"}";
		}
}
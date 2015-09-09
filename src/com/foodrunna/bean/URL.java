package com.foodrunna.bean;

import java.io.Serializable;

public class URL implements Serializable {
	
	public URL () {
		
	}
	private static String url = "http://localhost:8080/foodrunna/";
	//private static String url = "http://foodrunna.ec.fasthit.net.au/";
	public static String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}

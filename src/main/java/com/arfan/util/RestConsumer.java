package com.arfan.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import com.google.gson.Gson;

import models.Customer;
import models.OrderLine;
import models.Product;
import models.SalesOrder;

public class RestConsumer {
	
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String args[]) {
		RestConsumer consumer = new RestConsumer();
		
		HashMap<String, String> params = new HashMap<>();
		params.put("nama", "aku");
		params.put("puser", "bodong");
		String p = (consumer.get("http://localhost:8080/product/list", params));
		
		Gson gson = new Gson();
		
		Product[] products = gson.fromJson(p, Product[].class);
		
		for(Product pp: products) {
			System.out.println(pp);
		}
		
		String c = (consumer.get("http://localhost:8080/customer/list", params));
		
		Customer[] customers = gson.fromJson(c, Customer[].class);
		
		for(Customer cc: customers) {
			System.out.println(cc);
		}
		
		String s = (consumer.get("http://localhost:8080/salesorder/list", params));
		
		SalesOrder[] salesOrders = gson.fromJson(s, SalesOrder[].class);
		
		for(SalesOrder ss: salesOrders) {
			System.out.println(ss);
		}
		
		String o = (consumer.get("http://localhost:8080/orderline/list", params));
		
		OrderLine[] orderLines = gson.fromJson(o, OrderLine[].class);
		
		for(OrderLine oo: orderLines) {
			System.out.println(oo);
		}
	}

	public String get(String url, HashMap<String, String> params) {
		// TODO Auto-generated method stub
		StringBuilder urlBuilder = new StringBuilder();
		if(params!=null) {
			for(String key: params.keySet()) {
				try {
					urlBuilder.append(URLEncoder.encode(key, "UTF-8")+"="+URLEncoder.encode(params.get(key), "UTF-8")+"&");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			String urlParam = urlBuilder.toString();
			
			if(urlParam.endsWith("&")) {
				urlParam = urlParam.substring(0, urlParam.length()-1);
			}
			//System.out.println(url+"?"+urlParam);
			
			
			url = url+"?"+urlParam;
		}
		
		URL obj;
		HttpURLConnection con;
		try {
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			
			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);
			
			int responseCode = con.getResponseCode();
			//System.out.println("\nSending 'GET' request to URL : " + url);
			//System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			return (response.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

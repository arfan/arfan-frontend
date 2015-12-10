package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.arfan.util.RestConsumer;
import com.dev.frontend.panels.ComboBoxItem;
import com.google.gson.Gson;

import models.Customer;
import models.Product;

public class Services {
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	private static Gson gson = new Gson();
	private static RestConsumer rest = new RestConsumer();

	public static Object save(Object object, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called eventually after you click save on any edit
		 * screen object parameter is the return object from calling method
		 * guiToObject on edit screen and the type is identifier of the object
		 * type and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		if (objectType == TYPE_PRODUCT) {

			Product product = (Product) object;
			
			HashMap<String, String> params = new HashMap<>();
			params.put("code", Long.toString(product.getCode()));
			params.put("description", product.getDescription());
			params.put("price", product.getPrice().toString());
			params.put("quantity", Integer.toString(product.getQuantity()));
			
			String p = (rest.get("http://localhost:8080/product/update", params));
			//Product product = gson.fromJson(p, Product.class);

			System.out.println(p);
			return product;
		}
		return null;
	}

	public static Object readRecordByCode(String code, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you select record in list view of any
		 * entity and also called after you save a record to re-bind the record
		 * again the code parameter is the first column of the row you have
		 * selected and the type is identifier of the object type and may be
		 * TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */

		if (objectType == TYPE_PRODUCT) {

			HashMap<String, String> params = new HashMap<>();
			params.put("code", code);
			String p = (rest.get("http://localhost:8080/product/read", params));
			Product product = gson.fromJson(p, Product.class);

			return product;
		}

		return null;
	}

	public static boolean deleteRecordByCode(String code, int objectType) {
		if (objectType == TYPE_PRODUCT) {

			HashMap<String, String> params = new HashMap<>();
			params.put("code", code);
			String p = (rest.get("http://localhost:8080/product/delete", params));

			System.out.println(p);
			return true;
		}
		return true;
	}

	public static List<Object> listCurrentRecords(int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you open any list screen and should return
		 * all records of the specified type
		 */

		if (objectType == TYPE_PRODUCT) {

			String p = (rest.get("http://localhost:8080/product/list", null));
			Product[] products = gson.fromJson(p, Product[].class);

			ArrayList prod = new ArrayList();

			for (Product pp : products) {
				// System.out.println(pp);
				prod.add(pp);
			}

			return prod;
		} else if (objectType == TYPE_CUSTOMER) {
			String p = (rest.get("http://localhost:8080/customer/list", null));
			Customer[] customers = gson.fromJson(p, Customer[].class);

			ArrayList cust = new ArrayList();

			for (Customer cc : customers) {
				// System.out.println(pp);
				cust.add(cc);
			}

			return cust;
		}

		return new ArrayList<Object>();
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and
		 * should return list of ComboBoxItem which contains code and
		 * description/name for all records of specified type
		 */
		return new ArrayList<ComboBoxItem>();
	}

	public static double getProductPrice(String productCode) {
		// TODO by the candidate
		/*
		 * This method is used to get unit price of product with the code passed
		 * as a parameter
		 */

		return 1;
	}
}

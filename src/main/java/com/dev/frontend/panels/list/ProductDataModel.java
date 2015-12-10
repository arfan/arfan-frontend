package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Services;

import models.Product;


public class ProductDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() 
	{
		super(new String[]{"Code","Description","Price","Quantity"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		String[][] data = new String[list.size()][4];
		int i=0;
		for(Object pr: list) {
			Product product = (Product) pr;
			data[i][0] = Long.toString(product.getCode());
			data[i][1] = product.getDescription();
			data[i][2] = product.getPrice().toString();
			data[i][3] = Integer.toString(product.getQuantity());
			
			i++;
		}
		
		return data;
		//String[][] sampleData = new String [][]{{"01","Product 1","12.5","25"},{"02","Product 2","10","8"}};
		//return sampleData;
	}
}

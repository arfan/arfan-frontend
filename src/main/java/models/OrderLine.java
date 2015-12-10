package models;

public class OrderLine {

	private long id;
	private long productCode;
	private int quantity;	
	private long salesOrderNum;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProduct(long productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getSalesOrderNum() {
		return salesOrderNum;
	}

	public void setSalesOrderNum(long salesOrderNum) {
		this.salesOrderNum = salesOrderNum;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", productCode=" + productCode + ", quantity=" + quantity + ", salesOrderNum="
				+ salesOrderNum + "]";
	}

	
}

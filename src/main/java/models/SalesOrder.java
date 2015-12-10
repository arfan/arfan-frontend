package models;

public class SalesOrder {
	
	long orderNum;
    private long customerCode;

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public long getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(long customerCode) {
		this.customerCode = customerCode;
	}

	@Override
	public String toString() {
		return "SalesOrder [orderNum=" + orderNum + ", customerCode=" + customerCode + "]";
	}
	
}

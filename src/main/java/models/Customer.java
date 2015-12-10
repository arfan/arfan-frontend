package models;

import java.math.BigDecimal;

public class Customer {
	
	private long code;
	private String name;
	private String address;
	private String phone1;
	private String phone2;
	private BigDecimal creditLimit;
	private BigDecimal currentCredit;

	@Override
	public String toString() {
		return "Customer [code=" + code + ", name=" + name + ", address=" + address + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", creditLimit=" + creditLimit + ", currentCredit=" + currentCredit + "]";
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public BigDecimal getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(BigDecimal currentCredit) {
		this.currentCredit = currentCredit;
	}

	
}

package com.mertcan.demo.dto;

public class CustomersDTO {
	private Long id;
	private String companyName;
	private String address;
	private String phone;
	
	public CustomersDTO() {
	}

	public CustomersDTO(Long id, String companyName, String address, String phone) {
		this.id = id;
		this.companyName = companyName;
		this.address = address;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

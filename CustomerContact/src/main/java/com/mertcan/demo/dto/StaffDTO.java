package com.mertcan.demo.dto;

public class StaffDTO {
	private Long id;
	private String name;
	private String lastname;
	private String phone;
	
	public StaffDTO() {
	}

	public StaffDTO(Long id, String name, String lastname, String phone) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}

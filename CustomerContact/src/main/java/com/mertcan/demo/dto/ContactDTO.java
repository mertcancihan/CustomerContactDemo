package com.mertcan.demo.dto;

import com.mertcan.demo.entity.*;

public class ContactDTO {

	private Long id;
	private String date;
	private String time;
	private String subject;
	private String description;
	private Customer customer;
	private Staff staff;
	
	public ContactDTO() {
	}

	public ContactDTO(String date, String time, String subject, String description, Customer customer, Staff staff) {
		this.date = date;
		this.time = time;
		this.subject = subject;
		this.description = description;
		this.customer = customer;
		this.staff = staff;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
}

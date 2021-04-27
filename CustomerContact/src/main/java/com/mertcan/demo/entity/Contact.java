package com.mertcan.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
public class Contact{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;
    
    @JoinColumn(name = "staff_contact")
    @ManyToOne
    private Staff staff;

    @JoinColumn(name = "customers_contact")
    @ManyToOne
    private Customer customer;

	public Contact() {
	}

	public Contact(Long id, String date, String time, String subject, String description, Staff staff,
			Customer customer) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.subject = subject;
		this.description = description;
		this.staff = staff;
		this.customer = customer;
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
    
    
}

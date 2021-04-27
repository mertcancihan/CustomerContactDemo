package com.mertcan.demo.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @JoinColumn(name = "customers_contact")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Contact> contacts;

	public Customer() {
	}

	public Customer(String companyName, String address, String phone, List<Contact> contacts) {
		this.companyName = companyName;
		this.address = address;
		this.phone = phone;
		this.contacts = contacts;
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}

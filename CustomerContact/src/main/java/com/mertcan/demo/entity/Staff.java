package com.mertcan.demo.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "staff_name", length = 50)
    private String name;

    @Column(name = "staff_lastname", length = 50)
    private String lastname;
    
    @Column(name = "phone", length = 15)
    private String phone;

    @JoinColumn(name = "staff_contact")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Contact> contacts;

	public Staff() {
	}

	public Staff(String name, String lastname, String phone) {
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
	}

	public Staff(String name, String lastname, String phone, List<Contact> contacts) {
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.contacts = contacts;
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	
}

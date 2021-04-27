package com.mertcan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mertcan.demo.entity.Contact;

public interface IContactRepo extends JpaRepository<Contact,Long>{

}

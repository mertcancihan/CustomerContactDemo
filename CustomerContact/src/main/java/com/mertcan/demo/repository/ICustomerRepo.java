package com.mertcan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mertcan.demo.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Long>{

}

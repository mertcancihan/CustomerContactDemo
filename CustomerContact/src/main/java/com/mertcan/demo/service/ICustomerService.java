package com.mertcan.demo.service;

import java.util.List;

import com.mertcan.demo.entity.Customer;
import com.mertcan.demo.dto.CustomersDTO;

public interface ICustomerService {
	
	void save(Customer customer);

    List<CustomersDTO> getAll();
    
    CustomersDTO update (Long id, CustomersDTO customersDTO);
    
    CustomersDTO getById(Long id);
}

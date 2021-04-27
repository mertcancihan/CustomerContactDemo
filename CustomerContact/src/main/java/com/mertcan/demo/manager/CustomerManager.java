package com.mertcan.demo.manager;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mertcan.demo.dto.CustomersDTO;
import com.mertcan.demo.entity.Customer;
import com.mertcan.demo.repository.ICustomerRepo;
import com.mertcan.demo.service.ICustomerService;

@Service
public class CustomerManager implements ICustomerService{

	@Autowired
	private ICustomerRepo customerRepo;
	@Autowired
    private ModelMapper modelMapper;

    public CustomerManager(ICustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }
	
	@Override
	public void save(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public List<CustomersDTO> getAll() {
		List<Customer> listCustomer = customerRepo.findAll();
		return Arrays.asList(modelMapper.map(listCustomer, CustomersDTO[].class));
	}

	@Override
	public CustomersDTO update(Long id, CustomersDTO customersDTO) {
		Customer customer = customerRepo.getOne(id);
		customer.setCompanyName(customersDTO.getCompanyName());
		customer.setAddress(customersDTO.getAddress());
		customer.setPhone(customersDTO.getPhone());
		customerRepo.save(customer);
		return modelMapper.map(customer, CustomersDTO.class);
	}
	
	@Override
	public CustomersDTO getById(Long id) {
		return modelMapper.map(customerRepo.getOne(id),CustomersDTO.class);
	}

}

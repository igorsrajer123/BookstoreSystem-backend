package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Customer;
import com.example.bookstoreSystem.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findOneById(Long id) {
		return customerRepository.findOneById(id);
	}
	
	public Customer findOneByUserId(Long id) {
		return customerRepository.findOneByUserId(id);
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
}

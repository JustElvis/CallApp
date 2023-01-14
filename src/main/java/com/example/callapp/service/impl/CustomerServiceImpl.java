package com.example.callapp.service.impl;

import com.example.callapp.model.Customer;
import com.example.callapp.repository.CustomerRepository;
import com.example.callapp.service.CustomerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean existsCustomerByPhoneNumberAndEmail(String phoneNumber, String email) {
        return customerRepository.existsCustomerByPhoneNumberAndEmail(phoneNumber, email);
    }

    @Override
    public Customer findByPhoneNumberAndEmail(String phoneNumber, String email) {
        return customerRepository.findByPhoneNumberAndEmail(phoneNumber, email);
    }

    @Override
    public List<Customer> findAllByPhoneNumber(String phoneNumber) {
        return customerRepository.findAllByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Customer> findAllByEmail(String email) {
        return customerRepository.findAllByEmail(email);
    }
}

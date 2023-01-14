package com.example.callapp.service;

import com.example.callapp.model.Customer;
import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    boolean existsCustomerByPhoneNumberAndEmail(String phoneNumber, String email);

    Customer findByPhoneNumberAndEmail(String phoneNumber, String email);

    List<Customer> findAllByPhoneNumber(String phoneNumber);

    List<Customer> findAllByEmail(String email);
}

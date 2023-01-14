package com.example.callapp.service.mapper;

import com.example.callapp.dto.CustomerRequestDto;
import com.example.callapp.dto.CustomerResponseDto;
import com.example.callapp.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer mapToModel(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setApp(customerRequestDto.getApp());
        customer.setDateTime(customerRequestDto.getDateTime());
        return customer;
    }

    public CustomerResponseDto mapToDto(Customer customer) {
        CustomerResponseDto responseDto = new CustomerResponseDto();
        responseDto.setId(customer.getId());
        responseDto.setFirstName(customer.getFirstName());
        responseDto.setLastName(customer.getLastName());
        responseDto.setPhoneNumber(customer.getPhoneNumber());
        responseDto.setEmail(customer.getEmail());
        responseDto.setApp(customer.getApp());
        responseDto.setDateTime(customer.getDateTime());
        return responseDto;
    }
}

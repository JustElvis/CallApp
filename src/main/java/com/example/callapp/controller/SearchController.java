package com.example.callapp.controller;

import com.example.callapp.dto.CustomerResponseDto;
import com.example.callapp.model.Customer;
import com.example.callapp.service.CustomerService;
import com.example.callapp.service.mapper.CustomerMapper;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public SearchController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/by-phone")
    @ApiOperation(value = "Find customers by phone number.")
    public List<CustomerResponseDto> findCustomersByPhoneNumber(@RequestParam String phoneNumber) {
        List<Customer> customers = customerService.findAllByPhoneNumber(phoneNumber);
        return customers.stream()
                .map(customerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-email")
    @ApiOperation(value = "Find customers by email.")
    public List<CustomerResponseDto> findCustomersByEmail(@RequestParam String email) {
        List<Customer> customers = customerService.findAllByEmail(email);
        return customers.stream()
                .map(customerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

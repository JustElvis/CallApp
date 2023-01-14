package com.example.callapp.controller;

import com.example.callapp.dto.CustomerRequestDto;
import com.example.callapp.dto.CustomerResponseDto;
import com.example.callapp.service.CustomerService;
import com.example.callapp.service.mapper.CustomerMapper;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CallController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping("/call")
    @ApiOperation(value = "Save customer details to database if not exists.")
    public CustomerResponseDto incomingCall(@RequestBody @Valid CustomerRequestDto requestDto) {
        if (!customerService.existsCustomerByPhoneNumberAndEmail(requestDto.getPhoneNumber(),
                requestDto.getEmail())) {
            customerService.save(customerMapper.mapToModel(requestDto));
        }
        return customerMapper.mapToDto(customerService
                .findByPhoneNumberAndEmail(requestDto.getPhoneNumber(),
                requestDto.getEmail()));
    }
}

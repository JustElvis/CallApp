package com.example.callapp.controller;

import com.example.callapp.dto.CustomerRequestDto;
import com.example.callapp.service.mapper.CustomerMapper;
import com.example.callapp.service.CustomerService;
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
    public String incomingCall(@RequestBody @Valid CustomerRequestDto requestDto) {
        customerService.save(customerMapper.mapToModel(requestDto));
        return requestDto.getFirstName() + " " + requestDto.getLastName() + " are calling";
    }
}

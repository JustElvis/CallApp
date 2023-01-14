package com.example.callapp.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CustomerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String app;
    private LocalDateTime dateTime = LocalDateTime.now();
}

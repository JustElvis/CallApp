package com.example.callapp.dto;

import com.example.callapp.lib.ValidEmail;
import com.example.callapp.lib.ValidPhoneNumber;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private String firstName;
    private String lastName;
    @ValidPhoneNumber
    private String phoneNumber;
    @ValidEmail
    private String email;
    private String app;
    private LocalDateTime dateTime;
}

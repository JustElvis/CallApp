package com.example.callapp.dto;

import com.example.callapp.lib.ValidEmail;
import com.example.callapp.lib.ValidPhoneNumber;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @ValidPhoneNumber
    private String phoneNumber;
    @ValidEmail
    private String email;
    private String app;
    private LocalDateTime dateTime = LocalDateTime.now();
}

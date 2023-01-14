package com.example.callapp.controller;

import com.example.callapp.dto.CustomerRequestDto;
import com.example.callapp.model.Customer;
import com.example.callapp.service.CustomerService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.time.LocalDateTime;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class CallControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldCreateNewCustomerAndShow() {
        Customer customerToSave = new Customer();
        customerToSave.setFirstName("Yaroslav");
        customerToSave.setLastName("Shkvarla");
        customerToSave.setEmail("slav.shkvarlo@gmail.com");
        customerToSave.setPhoneNumber("+380992984576");
        customerToSave.setApp("CallApp");
        customerToSave.setDateTime(LocalDateTime.of(2023, 2, 15,
                5, 5, 0,0));
        Customer customerFromDatabase = new Customer();
        customerFromDatabase.setId(1L);
        customerFromDatabase.setFirstName("Yaroslav");
        customerFromDatabase.setLastName("Shkvarla");
        customerFromDatabase.setEmail("slav.shkvarlo@gmail.com");
        customerFromDatabase.setPhoneNumber("+380992984576");
        customerFromDatabase.setApp("CallApp");
        customerFromDatabase.setDateTime(LocalDateTime.of(2023, 2, 15,
                5, 5, 0,0));
        Mockito.when(customerService.save(customerToSave))
                .thenReturn(customerFromDatabase);
        Mockito.when(customerService.existsCustomerByPhoneNumberAndEmail("+380992984567",
                "slav.shkvarlo@gmail.com"))
                .thenReturn(false);
        Mockito.when(customerService.findByPhoneNumberAndEmail(customerToSave.getPhoneNumber(),
                        customerToSave.getEmail()))
                .thenReturn(customerFromDatabase);
        CustomerRequestDto requestDto = new CustomerRequestDto();
        requestDto.setFirstName(customerToSave.getFirstName());
        requestDto.setLastName(customerToSave.getLastName());
        requestDto.setPhoneNumber(customerToSave.getPhoneNumber());
        requestDto.setEmail(customerToSave.getEmail());
        requestDto.setApp(customerToSave.getApp());
        requestDto.setDateTime(customerToSave.getDateTime());
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post("/call")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("firstName", Matchers.equalTo("Yaroslav"))
                .body("lastName", Matchers.equalTo("Shkvarla"))
                .body("phoneNumber", Matchers.equalTo("+380992984576"))
                .body("email", Matchers.equalTo("slav.shkvarlo@gmail.com"))
                .body("app", Matchers.equalTo("CallApp"))
                .body("dateTime", Matchers.equalTo("2023-02-15T05:05:00"));
    }
}
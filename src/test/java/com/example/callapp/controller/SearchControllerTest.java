package com.example.callapp.controller;

import com.example.callapp.model.Customer;
import com.example.callapp.service.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
class SearchControllerTest {
    private static final String PHONE_NUMBER_FOR_SEARCH = "+380992984576";
    private static final String EMAIL_FOR_SEARCH = "+380992984576";

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldReturnCustomersByPhoneNumber() {
        Customer customerYaroslav = new Customer();
        customerYaroslav.setId(5L);
        customerYaroslav.setFirstName("Yaroslav");
        customerYaroslav.setLastName("Shkvarla");
        customerYaroslav.setEmail("slav.shkvarlo@gmail.com");
        customerYaroslav.setPhoneNumber("+380992984576");
        customerYaroslav.setApp("CallApp");
        customerYaroslav.setDateTime(LocalDateTime.of(2023, 2, 15,
                5, 5, 0,0));
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(customerYaroslav);
        Mockito.when(customerService.findAllByPhoneNumber(PHONE_NUMBER_FOR_SEARCH))
                .thenReturn(mockCustomers);
        RestAssuredMockMvc
                .given()
                .queryParam("phoneNumber", PHONE_NUMBER_FOR_SEARCH)
                .when()
                .get("/search/by-phone")
                .then()
                .body("size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(5))
                .body("[0].firstName", Matchers.equalTo("Yaroslav"))
                .body("[0].lastName", Matchers.equalTo("Shkvarla"))
                .body("[0].email", Matchers.equalTo("slav.shkvarlo@gmail.com"))
                .body("[0].phoneNumber", Matchers.equalTo("+380992984576"))
                .body("[0].app", Matchers.equalTo("CallApp"))
                .body("[0].dateTime", Matchers.equalTo("2023-02-15T05:05:00"));
    }

    @Test
    public void shouldReturnCustomersByEmail() {
        Customer customerYaroslav = new Customer();
        customerYaroslav.setId(5L);
        customerYaroslav.setFirstName("Yaroslav");
        customerYaroslav.setLastName("Shkvarla");
        customerYaroslav.setEmail("slav.shkvarlo@gmail.com");
        customerYaroslav.setPhoneNumber("+380992984576");
        customerYaroslav.setApp("CallApp");
        customerYaroslav.setDateTime(LocalDateTime.of(2023, 2, 15,
                5, 5, 0,0));
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(customerYaroslav);
        Mockito.when(customerService.findAllByEmail(EMAIL_FOR_SEARCH))
                .thenReturn(mockCustomers);
        RestAssuredMockMvc
                .given()
                .queryParam("email", EMAIL_FOR_SEARCH)
                .when()
                .get("/search/by-email")
                .then()
                .body("size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(5))
                .body("[0].firstName", Matchers.equalTo("Yaroslav"))
                .body("[0].lastName", Matchers.equalTo("Shkvarla"))
                .body("[0].email", Matchers.equalTo("slav.shkvarlo@gmail.com"))
                .body("[0].phoneNumber", Matchers.equalTo("+380992984576"))
                .body("[0].app", Matchers.equalTo("CallApp"))
                .body("[0].dateTime", Matchers.equalTo("2023-02-15T05:05:00"));
    }

}
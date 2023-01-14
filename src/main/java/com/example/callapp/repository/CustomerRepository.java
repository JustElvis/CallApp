package com.example.callapp.repository;

import com.example.callapp.model.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsCustomerByPhoneNumberAndEmail(String phoneNumber, String email);

    Customer findByPhoneNumberAndEmail(String phoneNumber, String email);

    List<Customer> findAllByPhoneNumber(String phoneNumber);

    List<Customer> findAllByEmail(String email);
}

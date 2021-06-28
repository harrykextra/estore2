package com.ourstore.dao.address;

import com.ourstore.dao.customer.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }
}
package com.ourstore.dao.address;

import com.ourstore.dao.customer.CustomerRepository;
import com.ourstore.model.DataConfig;
import com.ourstore.model.address.Address;
import com.ourstore.model.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@ComponentScan(basePackages = {"com.ourstore.dao"})
//@SpringBootTest(classes = DataConfig.class)
@SpringBootTest
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    CustomerRepository customerRepository;

//    public AddressRepositoryTest(AddressRepository addressRepository, CustomerRepository customerRepository) {
//        this.addressRepository = addressRepository;
//        this.customerRepository = customerRepository;
//    }

    Address address;

    Customer customer;

    @BeforeEach
    void setUp() {
        address = new Address();
        customer = new Customer();
    }

    @Test
    void saveAddressTest() {

        address.setStreet("5, Yomi street");
        address.setCity("Ibara");
        address.setState("Ogun");
        address.setCountry("Nigeria");
        address.setZipcode("10101");

         Customer customer = customerRepository.findById(1).orElse(null);

        address.setCustomers(customer);

       Address savedAddress = addressRepository.save(address);

       assertNotNull(savedAddress);
//        assertDoesNotThrow(() -> addressRepository.save(address));
    }

    @Test
    void updateAddressTest(){
        address = addressRepository.findById(1).orElse(null);
//        assert address != null;
        assertNotNull(address);
        assertThat(address.getCity()).isEqualTo("Yaba");
        address.setCity("Jibowu");
        assertThat(address.getCity()).isEqualTo("Jibowu");
    }
}
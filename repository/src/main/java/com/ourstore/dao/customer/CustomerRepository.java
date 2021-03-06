package com.ourstore.dao.customer;

import com.ourstore.dao.exceptions.CustomerException;
import com.ourstore.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public default Customer saveCustomer (Customer customer) throws CustomerException {
        if (!customerHasEmail(customer)) {
            throw new CustomerException("Email address can not be null");
        } else if (!customerHasPassword(customer)) {
            throw new CustomerException(("Password is required"));
        } else if (!customerHasFullName(customer)) {
            throw new CustomerException("Full names required");
        }
        return save(customer);
    }

    private boolean customerHasEmail (Customer customer) {
        return customer.getEmail() != null;
    }

    private boolean customerHasPassword (Customer customer) {
        return customer.getPassword() != null;
    }

    private boolean customerHasFullName (Customer customer) {
        return customer.getFirstName() != null && customer.getLastName() != null;
    }
}

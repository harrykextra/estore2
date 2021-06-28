package com.ourstore.service.address;

import com.ourstore.dao.exceptions.AddressException;
import com.ourstore.model.address.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {

    void saveAddress (Address address);

    void updateAddress(Address address) throws AddressException;

    Address findAddressById(Integer id);

    List<Address> findAllAddresses();

    void deleteAddressById (Integer id);
}

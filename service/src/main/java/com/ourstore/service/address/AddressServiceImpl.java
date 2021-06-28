package com.ourstore.service.address;

import com.ourstore.dao.address.AddressRepository;
import com.ourstore.dao.exceptions.AddressException;
import com.ourstore.model.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Address address) throws AddressException{
        if (address.getId() == null){
            throw new AddressException("Address id cannot be null");


            Address address1 = addressRepository.findById(address.getId()).orElse(null);


            if(address1 == null){
                throw new AddressException("this  address is not in our database");
            }else{
                if(address.getStreet() != null){
                    address1.setStreet(address.getStreet());
                }
                if(address.getCity() != null){
                    address1.setCity(address.getCity());
                } if(address.getZipcode() != null){
                    address1.setZipcode(address.getZipcode());
                } if(address.getCountry() != null){
                    address1.setState(address.getState());
                } if (address.getCustomers() != null){
                    address1.setCustomers(customer);
                }
                addressRepository.saveAddress(address1);
            }
        }
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddressById(Integer id) {
        addressRepository.deleteById(id);
    }
}

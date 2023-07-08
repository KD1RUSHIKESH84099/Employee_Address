package com.geekster.Employee_Address.service;

import com.geekster.Employee_Address.model.Address;
import com.geekster.Employee_Address.model.Employee;
import com.geekster.Employee_Address.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public List<Address> getAllAddress() {
        return (List<Address>) addressRepo.findAll();
    }

    public Address getAddressById(Long addId) {
        Optional<Address> add = addressRepo.findById(addId);
        return add.isPresent() ? add.get():null;
    }

    public String deleteById(Long addId) {
        addressRepo.deleteById(addId);
        return "Employee Removed For Id "+ addId;
    }

    public String updateById(Long addId, Address address) {
        Optional<Address> add = addressRepo.findById(addId);
        Address addr  = null;
        if(add.isPresent()){
            addr = add.get();
        }else{
            return "Employee Not Found";
        }
        addr.setStreet(address.getStreet());
        addr.setCity(address.getCity());
        addr.setState(address.getState());
        addr.setZipcode(address.getZipcode());


        addressRepo.save(addr);
        return "Employee Updated";


    }
}

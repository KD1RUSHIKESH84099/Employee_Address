package com.geekster.Employee_Address.controller;

import com.geekster.Employee_Address.model.Address;
import com.geekster.Employee_Address.model.Employee;
import com.geekster.Employee_Address.service.AddressService;
import com.geekster.Employee_Address.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }


    @GetMapping("addresses")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @GetMapping("address/{addId}")
    public Address getAddressById(@PathVariable Long addId){
        return addressService.getAddressById(addId);
    }
    @DeleteMapping("deleteAddress/{addId}")
    public String deleteById(@PathVariable Long addId){
        return addressService.deleteById(addId);
    }
    @PutMapping("updateAddress/{addId}/{updatedAddress}")
    public String updateById(@PathVariable Long addId , @RequestBody Address address){
        return addressService.updateById(addId , address);
    }






}

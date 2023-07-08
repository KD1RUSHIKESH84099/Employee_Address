package com.geekster.Employee_Address.controller;

import com.geekster.Employee_Address.model.Employee;
import com.geekster.Employee_Address.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("employee/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId){
        return employeeService.getEmployeeById(empId);
    }
    @DeleteMapping("delete/{empId}")
    public String deleteById(@PathVariable Long empId){
        return employeeService.deleteById(empId);
    }
    @PutMapping("update/{empId}/{updatedEmployee}")
    public String updateById(@PathVariable Long empId , @RequestBody Employee employee){
        return employeeService.updateById(empId , employee);
    }


}

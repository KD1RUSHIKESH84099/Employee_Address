package com.geekster.Employee_Address.service;

import com.geekster.Employee_Address.model.Employee;
import com.geekster.Employee_Address.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long empId) {
        Optional<Employee> emp = employeeRepo.findById(empId);
        return emp.isPresent() ? emp.get():null;


    }

    public String deleteById(Long empId) {
         employeeRepo.deleteById(empId);
         return "Employee Removed For Id "+ empId;

    }

    public String updateById(Long empId, Employee employee) {
        Optional<Employee> emp = employeeRepo.findById(empId);
        Employee empl  = null;
        if(emp.isPresent()){
            empl = emp.get();
        }else{
            return "Employee Not Found";
        }
        empl.setFirstName(employee.getFirstName());
        empl.setLastName(employee.getLastName());
        //empl.setAddress(employee.getAddress());
        employeeRepo.save(empl);
        return "Employee Updated";


    }
}

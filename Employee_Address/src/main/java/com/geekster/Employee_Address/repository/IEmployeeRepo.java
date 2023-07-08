    package com.geekster.Employee_Address.repository;

    import com.geekster.Employee_Address.model.Employee;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface IEmployeeRepo extends CrudRepository<Employee,Long> {
    }

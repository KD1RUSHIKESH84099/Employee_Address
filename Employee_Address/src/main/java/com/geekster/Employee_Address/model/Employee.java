package com.geekster.Employee_Address.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long empId;

    private String firstName;

    private String lastName;
    @OneToOne
    @JoinColumn(name = "fk_addressId")
    Address address;







}

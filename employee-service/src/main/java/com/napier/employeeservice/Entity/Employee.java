package com.napier.employeeservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_Name")
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    private String departmentCode;
    private String organizationCode;
}

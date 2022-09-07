package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "departments")
public class Department {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Set<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @PrePersist
    public void onPrePersist() {
        System.out.println("\n********* Before persisting department object: " + name);
    }

    @PostPersist
    public void onPostPersist() {
        System.out.println("\n********* after persisting department object: " + name);
    }
    @PostLoad
    public void onPostLoad() {
        System.out.println("\n********* after loading department object: " + name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = new HashSet<>();
        }

        employees.add(employee);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Employees: " + employees;
    }
}

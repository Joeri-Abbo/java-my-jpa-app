package com.skillsoft.jpa;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity(name = "departments")
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Set<FullTimeEmployee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
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

    public Set<FullTimeEmployee> getEmployees() {
        return employees;
    }

    public void addEmployee(FullTimeEmployee employee) {
        if (employees == null) {
            employees = new HashSet<>();
        }
        employees.add(employee);
    }
}

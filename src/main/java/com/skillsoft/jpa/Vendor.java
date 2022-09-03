package com.skillsoft.jpa;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity(name = "vendors")
public class Vendor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    private Set<ContractEmployee> employees;

    public Vendor() {

    }

    public Vendor(String name) {
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

    public Set<ContractEmployee> getEmployees() {
        return employees;
    }

    public void addEmployee(ContractEmployee employee) {
        if (employees == null) {
            employees = new HashSet<>();
        }
        employees.add(employee);
    }
}

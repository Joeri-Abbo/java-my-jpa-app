package com.skillsoft.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    @PrePersist
    public void onPrePersist() {
        System.out.println("\n********* Before persisting employee object: " + name);
    }

    @PostPersist
    public void onPostPersist() {
        System.out.println("\n********* after persisting employee object: " + name);
    }
    @PostLoad
    public void onPostLoad() {
        System.out.println("\n********* after loading employee object: " + name);
    }

    @PreUpdate
    public void onPreUpdate() {
        System.out.println("\n********* Before updating employee object: " + name);
    }

    @PostUpdate
    public void onPostUpdate() {
        System.out.println("\n********* after updating employee object: " + name);
    }
    @PreRemove
    public void onPreRemove() {
        System.out.println("\n********* Before removing employee object: " + name);
    }

    @PostRemove
    public void onPostRemove() {
        System.out.println("\n********* after removing employee object: " + name);
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

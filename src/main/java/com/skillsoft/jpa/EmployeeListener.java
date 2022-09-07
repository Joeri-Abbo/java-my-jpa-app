package com.skillsoft.jpa;

import javax.persistence.*;

public class EmployeeListener {

    @PrePersist
    public void onPrePersist(Employee employee) {
        System.out.println("\n********* Before persisting employee object: " + employee.getName());
    }

    @PostPersist
    public void onPostPersist(Employee employee) {
        System.out.println("\n********* after persisting employee object: " + employee.getName());
    }

    @PostLoad
    public void onPostLoad(Employee employee) {
        System.out.println("\n********* after loading employee object: " + employee.getName());
    }

    @PreUpdate
    public void onPreUpdate(Employee employee) {
        System.out.println("\n********* Before updating employee object: " + employee.getName());
    }

    @PostUpdate
    public void onPostUpdate(Employee employee) {
        System.out.println("\n********* after updating employee object: " + employee.getName());
    }

    @PreRemove
    public void onPreRemove(Employee employee) {
        System.out.println("\n********* Before removing employee object: " + employee.getName());
    }

    @PostRemove
    public void onPostRemove(Employee employee) {
        System.out.println("\n********* after removing employee object: " + employee.getName());
    }
}

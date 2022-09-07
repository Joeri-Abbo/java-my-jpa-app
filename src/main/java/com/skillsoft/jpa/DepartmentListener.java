package com.skillsoft.jpa;

import javax.persistence.*;

public class DepartmentListener {
    @PrePersist
    public void onPrePersist(Department department) {
        System.out.println("\n********* Before persisting department object: " + department.getName());
    }

    @PostPersist
    public void onPostPersist(Department department) {
        System.out.println("\n********* after persisting department object: " + department.getName());
    }

    @PostLoad
    public void onPostLoad(Department department) {
        System.out.println("\n********* after loading department object: " + department.getName());
    }

    @PreUpdate
    public void onPreUpdate(Department department) {
        System.out.println("\n********* Before updating department object: " + department.getName());
    }

    @PostUpdate
    public void onPostUpdate(Department department) {
        System.out.println("\n********* after updating department object: " + department.getName());
    }

    @PreRemove
    public void onPreRemove(Department department) {
        System.out.println("\n********* Before removing department object: " + department.getName());
    }

    @PostRemove
    public void onPostRemove(Department department) {
        System.out.println("\n********* after removing department object: " + department.getName());
    }


}

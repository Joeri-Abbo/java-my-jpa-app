package com.skillsoft.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("not null")
public class UnknownEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    public UnknownEmployee() {

    }

    public UnknownEmployee(String name) {
        super(name);
    }
}

package com.skillsoft.jpa;

import javax.persistence.*;

@Embeddable
public class Course {
    private String level;
    private String name;

    public Course() {

    }

    public Course(String code, String name) {
        this.level = code;
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


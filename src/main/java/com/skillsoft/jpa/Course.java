package com.skillsoft.jpa;

import java.util.Objects;
import javax.persistence.*;

@Entity(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String level;
    private String name;

    public Course() {

    }

    public Course(String code, String name) {
        this.level = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        return Objects.hash(level, name);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Course)) {
            return false;
        }

        Course otherCourse = (Course) other;

        return name.equals(((Course) other).name) && level.equals(otherCourse.level);
    }
}


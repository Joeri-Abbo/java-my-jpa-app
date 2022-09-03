package com.skillsoft.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Students")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> courses;

    public Student() {

    }

    public Student(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "\n{" + id + ", " + name + "}\n";
    }
}

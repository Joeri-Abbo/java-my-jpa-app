package com.skillsoft.jpa;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.*;

@Entity(name = "Students")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "students_courses")
    @MapKeyColumn(name = "course_id")
    @Column(name = "course_code")
    private Map<Course, Integer> courses;

    public Student() {

    }

    public Student(String name, Map<Course, Integer> courses) {
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

    public Map<Course, Integer> getCourses() {
        return courses;
    }

    public void setCourses(Map<Course, Integer> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "\n{" + id + ", " + name + "}\n";
    }
}

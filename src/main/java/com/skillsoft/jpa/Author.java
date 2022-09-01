package com.skillsoft.jpa;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
public class Author {

    private Integer id;
    private String name;
    private Date birthDate;

    public Author() {

    }

    public Author(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Id
    @SequenceGenerator(name = "bookstore_seq", sequenceName = "BOOK_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookstore_seq")
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

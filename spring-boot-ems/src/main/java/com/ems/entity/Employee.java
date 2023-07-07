package com.ems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    //entities
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "email")
    private String email;

    // constructors

    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
    }

    //getters, setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString()

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

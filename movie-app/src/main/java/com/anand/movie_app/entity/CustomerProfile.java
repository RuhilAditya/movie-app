package com.anand.movie_app.entity;

import jakarta.persistence.*;

@Entity
@Table
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String fullName;
    String email;
    String location;

    public CustomerProfile () {}

    public CustomerProfile(long id, String fullName, String email, String location) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    private Long id;
    private String name;
    private String licenseNumber;
    private String phone;

    public Driver() {}

 
    public Driver(Long id, String name, String licenseNumber, String phone) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
    }

 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

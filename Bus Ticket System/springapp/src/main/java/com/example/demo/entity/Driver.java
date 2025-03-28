package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private String phone;

    // The owning side of the relationship
    @OneToOne
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonBackReference
    private Bus assignedBus;

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

    public Bus getAssignedBus() {
        return assignedBus;
    }

    public void setAssignedBus(Bus assignedBus) {
        this.assignedBus = assignedBus;
    }
}
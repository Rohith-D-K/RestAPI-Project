package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    private Long id;
    private String username;
    private String busNumber;
    private Integer seatNumber;

    public Booking() {}

    public Booking(Long id, String username, String busNumber, Integer seatNumber) {
        this.id = id;
        this.username = username;
        this.busNumber = busNumber;
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
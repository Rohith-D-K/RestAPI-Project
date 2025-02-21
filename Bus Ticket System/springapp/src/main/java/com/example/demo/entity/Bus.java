package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Bus {
    @Id
    private Long id;
    private String busNumber;
    private String route;
    private int capacity;
    private String driverName;


    
    public Bus() {}

    
    public Bus(Long id, String busNumber, String route, int capacity, String driverName) {
        this.id = id;
        this.busNumber = busNumber;
        this.route = route;
        this.capacity = capacity;
        this.driverName = driverName;
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

}
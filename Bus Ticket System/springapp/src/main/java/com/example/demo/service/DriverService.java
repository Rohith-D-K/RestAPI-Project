package com.example.demo.service;

import com.example.demo.entity.Bus;
import com.example.demo.entity.Driver;
import com.example.demo.repository.BusRepository;
import com.example.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BusRepository busRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Transactional
    public Driver createDriver(Driver driver) {
        // Check if the assignedBus exists
        if (driver.getAssignedBus() != null && driver.getAssignedBus().getId() != null) {
            Bus bus = busRepository.findById(driver.getAssignedBus().getId()).orElse(null);
            if (bus != null) {
                driver.setAssignedBus(bus);
            }
        }
        return driverRepository.save(driver);
    }

    @Transactional
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    public List<Driver> getAllDriversPaginated(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return driverRepository.findAll(pageable).getContent();
    }

    public List<Driver> getAllDriversSorted(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return driverRepository.findAll(sort);
    }

    public List<Driver> getAllDriversPaginatedAndSorted(int offset, int pageSize, String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        Pageable pageable = PageRequest.of(offset, pageSize, sort);
        return driverRepository.findAll(pageable).getContent();
    }

    public List<Driver> findByName(String name) {
        return driverRepository.findByName(name);
    }

    public Driver findByLicenseNumber(String licenseNumber) {
        return driverRepository.findByLicenseNumber(licenseNumber);
    }

    // Add this method to your DriverService.java
public Driver findById(Long id) {
    return driverRepository.findById(id).orElse(null);
}

    public List<Driver> findByPhone(String phone) {
        return driverRepository.findByPhone(phone);
    }

    @Transactional
    public Driver assignBusToDriver(Long driverId, Long busId) {
        Driver driver = driverRepository.findById(driverId).orElse(null);
        Bus bus = busRepository.findById(busId).orElse(null);
        
        if (driver != null && bus != null) {
            driver.setAssignedBus(bus);
            return driverRepository.save(driver);
        }
        return null;
    }

    @Transactional
    public Driver updateDriver(Long id, Driver driverDetails) {
        Driver driver = driverRepository.findById(id).orElse(null);
        if (driver != null) {
            driver.setName(driverDetails.getName());
            driver.setLicenseNumber(driverDetails.getLicenseNumber());
            driver.setPhone(driverDetails.getPhone());
            
            // Update bus assignment if provided
            if (driverDetails.getAssignedBus() != null && driverDetails.getAssignedBus().getId() != null) {
                Bus bus = busRepository.findById(driverDetails.getAssignedBus().getId()).orElse(null);
                if (bus != null) {
                    driver.setAssignedBus(bus);
                }
            }
            return driverRepository.save(driver);
        }
        return null;
    }
}
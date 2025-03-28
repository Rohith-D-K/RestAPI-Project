package com.example.demo.controller;

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driverDetails) {
        Driver updatedDriver = driverService.updateDriver(id, driverDetails);
        if (updatedDriver != null) {
            return ResponseEntity.ok(updatedDriver);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{offset}/{pageSize}")
    public List<Driver> getAllDriversPaginated(@PathVariable int offset, @PathVariable int pageSize) {
        return driverService.getAllDriversPaginated(offset, pageSize);
    }

    @GetMapping("/sortBy/{field}")
    public List<Driver> getAllDriversSorted(@PathVariable String field) {
        return driverService.getAllDriversSorted(field);
    }

    @GetMapping("/{offset}/{pageSize}/{field}")
    public List<Driver> getAllDriversPaginatedAndSorted(
            @PathVariable int offset, 
            @PathVariable int pageSize, 
            @PathVariable String field) {
        return driverService.getAllDriversPaginatedAndSorted(offset, pageSize, field);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<Driver>> getDriversByName(@RequestParam String name) {
        List<Driver> drivers = driverService.findByName(name);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/byLicense")
    public ResponseEntity<Driver> getDriverByLicense(@RequestParam String licenseNumber) {
        Driver driver = driverService.findByLicenseNumber(licenseNumber);
        return driver != null ? ResponseEntity.ok(driver) : ResponseEntity.notFound().build();
    }

    @GetMapping("/byPhone")
    public ResponseEntity<List<Driver>> getDriversByPhone(@RequestParam String phone) {
        List<Driver> drivers = driverService.findByPhone(phone);
        return ResponseEntity.ok(drivers);
    }

    @PostMapping("/{driverId}/assign-bus/{busId}")
    public ResponseEntity<Driver> assignBusToDriver(@PathVariable Long driverId, @PathVariable Long busId) {
        Driver driver = driverService.assignBusToDriver(driverId, busId);
        if (driver != null) {
            return ResponseEntity.ok(driver);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Driver driver = driverService.findById(id);
        if (driver != null) {
            return ResponseEntity.ok(driver);
        }
        return ResponseEntity.notFound().build();
    }
}
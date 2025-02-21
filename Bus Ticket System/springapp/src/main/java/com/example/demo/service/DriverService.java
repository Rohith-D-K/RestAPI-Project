package com.example.demo.service;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

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

    public List<Driver> findByPhone(String phone) {
        return driverRepository.findByPhone(phone);
    }
}

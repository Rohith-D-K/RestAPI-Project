package com.example.demo.repository;

import com.example.demo.entity.Driver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
     @Query("SELECT d FROM Driver d WHERE d.name = :name")
    List<Driver> findByName(@Param("name") String name);

    @Query("SELECT d FROM Driver d WHERE d.licenseNumber = :licenseNumber")
    Driver findByLicenseNumber(@Param("licenseNumber") String licenseNumber);

    @Query("SELECT d FROM Driver d WHERE d.phone = :phone")
    List<Driver> findByPhone(@Param("phone") String phone);
}

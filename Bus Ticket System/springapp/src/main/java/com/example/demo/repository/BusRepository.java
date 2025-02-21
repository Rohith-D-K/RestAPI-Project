package com.example.demo.repository;

import com.example.demo.entity.Bus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    @Query("SELECT b FROM Bus b WHERE b.route = :route")
    List<Bus> findByRoute(@Param("route") String route);

    @Query("SELECT b FROM Bus b WHERE b.busNumber = :busNumber")
    Bus findByBusNumber(@Param("busNumber") String busNumber);

    @Query("SELECT b FROM Bus b WHERE b.driverName = :driverName")
    List<Bus> findByDriverName(@Param("driverName") String driverName);
}

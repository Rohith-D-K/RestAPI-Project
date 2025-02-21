package com.example.demo.repository;

import com.example.demo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.username = :username")
    List<Booking> findByUsername(@Param("username") String username);

    @Query("SELECT b FROM Booking b WHERE b.busNumber = :busNumber")
    List<Booking> findByBusNumber(@Param("busNumber") String busNumber);

}
package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        Booking updatedBooking = bookingService.updateBooking(id, bookingDetails);
        if (updatedBooking != null) {
            return ResponseEntity.ok(updatedBooking);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{offset}/{pageSize}")
    public List<Booking> getAllBookingsPaginated(@PathVariable int offset, @PathVariable int pageSize) {
        return bookingService.getAllBookingsPaginated(offset, pageSize);
    }

    @GetMapping("/sortBy/{field}")
    public List<Booking> getAllBookingsSorted(@PathVariable String field) {
        return bookingService.getAllBookingsSorted(field);
    }

    @GetMapping("/byUsername")
    public ResponseEntity<List<Booking>> getBookingsByUsername(@RequestParam String username) {
        List<Booking> bookings = bookingService.findByUsername(username);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/byBusNumber")
    public ResponseEntity<List<Booking>> getBookingsByBusNumber(@RequestParam String busNumber) {
        List<Booking> bookings = bookingService.findByBusNumber(busNumber);
        return ResponseEntity.ok(bookings);
    }

}
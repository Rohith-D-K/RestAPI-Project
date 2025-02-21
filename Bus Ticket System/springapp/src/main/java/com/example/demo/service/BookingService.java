package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setUsername(bookingDetails.getUsername());
            booking.setBusNumber(bookingDetails.getBusNumber());
            booking.setSeatNumber(bookingDetails.getSeatNumber());
            return bookingRepository.save(booking);
        }
        return null;
    }

    public List<Booking> getAllBookingsPaginated(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return bookingRepository.findAll(pageable).getContent();
    }

    public List<Booking> getAllBookingsSorted(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return bookingRepository.findAll(sort);
    }

    public List<Booking> findByUsername(String username) {
        return bookingRepository.findByUsername(username);
    }

    public List<Booking> findByBusNumber(String busNumber) {
        return bookingRepository.findByBusNumber(busNumber);
    }
}
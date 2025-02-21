package com.example.demo.service;

import com.example.demo.entity.Bus;
import com.example.demo.repository.BusRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Transactional
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Transactional
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    public List<Bus> getAllBusesPaginated(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return busRepository.findAll(pageable).getContent();
    }

    public List<Bus> getAllBusesSorted(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return busRepository.findAll(sort);
    }

    public List<Bus> getAllBusesPaginatedAndSorted(int offset, int pageSize, String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        Pageable pageable = PageRequest.of(offset, pageSize, sort);
        return busRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Bus updateBus(Long id, Bus busDetails) {
        Bus bus = busRepository.findById(id).orElse(null);
        if (bus != null) {
            bus.setBusNumber(busDetails.getBusNumber());
            bus.setRoute(busDetails.getRoute());
            bus.setCapacity(busDetails.getCapacity());
            bus.setDriverName(busDetails.getDriverName());
            return busRepository.save(bus);
        }
        return null;
    }

    public List<Bus> findByRoute(String route) {
        return busRepository.findByRoute(route);
    }

    public Bus findByBusNumber(String busNumber) {
        return busRepository.findByBusNumber(busNumber);
    }

    public List<Bus> findByDriverName(String driverName) {
        return busRepository.findByDriverName(driverName);
    }

}

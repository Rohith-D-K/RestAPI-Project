package com.example.demo.controller;

import com.example.demo.entity.Bus;
import com.example.demo.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public Bus createBus(@RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{offset}/{pageSize}")
    public List<Bus> getAllBusesPaginated(@PathVariable int offset, @PathVariable int pageSize) {
        return busService.getAllBusesPaginated(offset, pageSize);
    }

    @GetMapping("/sortBy/{field}")
    public List<Bus> getAllBusesSorted(@PathVariable String field) {
        return busService.getAllBusesSorted(field);
    }

    @GetMapping("/{offset}/{pageSize}/{field}")
    public List<Bus> getAllBusesPaginatedAndSorted(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        return busService.getAllBusesPaginatedAndSorted(offset, pageSize, field);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus busDetails) {
    Bus updatedBus = busService.updateBus(id, busDetails);
    if (updatedBus != null) {
        return ResponseEntity.ok(updatedBus);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @GetMapping("/byRoute")
    public ResponseEntity<List<Bus>> getBusesByRoute(@RequestParam String route) {
        List<Bus> buses = busService.findByRoute(route);
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/byBusNumber")
    public ResponseEntity<Bus> getBusByBusNumber(@RequestParam String busNumber) {
        Bus bus = busService.findByBusNumber(busNumber);
        return bus != null ? ResponseEntity.ok(bus) : ResponseEntity.notFound().build();
    }

    @GetMapping("/byDriver")
    public ResponseEntity<List<Bus>> getBusesByDriverName(@RequestParam String driverName) {
        List<Bus> buses = busService.findByDriverName(driverName);
        return ResponseEntity.ok(buses);
    }
}

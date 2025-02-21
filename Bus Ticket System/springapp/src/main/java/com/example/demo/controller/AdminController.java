package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{offset}/{pageSize}")
    public List<Admin> getAllAdminsPaginated(@PathVariable int offset, @PathVariable int pageSize) {
        return adminService.getAllAdminsPaginated(offset, pageSize);
    }

    @GetMapping("/sortBy/{field}")
    public List<Admin> getAllAdminsSorted(@PathVariable String field) {
        return adminService.getAllAdminsSorted(field);
    }

    @GetMapping("/{offset}/{pageSize}/{field}")
    public List<Admin> getAllAdminsPaginatedAndSorted(@PathVariable int offset, @PathVariable int pageSize,
            @PathVariable String field) {
        return adminService.getAllAdminsPaginatedAndSorted(offset, pageSize, field);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<List<Admin>> getAdminsByEmail(@RequestParam String email) {
        List<Admin> admins = adminService.findByEmail(email);
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/byName")
    public ResponseEntity<Admin> getAdminByName(@RequestParam String name) {
        Admin admin = adminService.findByName(name);
        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

    @GetMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestParam String name, @RequestParam String password) {
        Admin admin = adminService.findByNameAndPassword(name, password);
        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }
}

package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public List<Admin> getAllAdminsPaginated(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return adminRepository.findAll(pageable).getContent();
    }

    public List<Admin> getAllAdminsSorted(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return adminRepository.findAll(sort);
    }

    public List<Admin> getAllAdminsPaginatedAndSorted(int offset, int pageSize, String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        Pageable pageable = PageRequest.of(offset, pageSize, sort);
        return adminRepository.findAll(pageable).getContent();
    }

    public List<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Transactional
    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());  
            return adminRepository.save(admin);
        }
        return null;
    }

    public Admin findByName(String name) {
        return adminRepository.findByName(name);
    }

    public Admin findByNameAndPassword(String name, String password) {
        return adminRepository.findByNameAndPassword(name, password);
    }
}

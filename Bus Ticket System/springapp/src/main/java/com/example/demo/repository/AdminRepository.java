package com.example.demo.repository;

import com.example.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.email = :email")
    List<Admin> findByEmail(@Param("email") String email);
    
    @Query("SELECT a FROM Admin a WHERE a.name = :name")
    Admin findByName(@Param("name") String name);
    
    @Query("SELECT a FROM Admin a WHERE a.name = :name AND a.password = :password")
    Admin findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
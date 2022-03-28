package com.virtualbiblio.virtualbiblio.repository;

import com.virtualbiblio.virtualbiblio.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByLoginAndPassword(String login, String password);
    List<Admin> findByDeleted(Boolean deleted);
    Optional<Admin> findByEmail(String nom);
}

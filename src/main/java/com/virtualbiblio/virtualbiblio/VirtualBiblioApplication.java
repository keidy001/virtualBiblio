package com.virtualbiblio.virtualbiblio;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import static com.virtualbiblio.virtualbiblio.model.Role.SuperAdmin;

@SpringBootApplication

public class VirtualBiblioApplication implements CommandLineRunner {
    @Autowired
    AdminRepository adminRepository;
    public static void main(String[] args) {
        SpringApplication.run(VirtualBiblioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional defaultAdmin = adminRepository.findByEmail("vbiblio@gmail.com");
        if (defaultAdmin.isEmpty()) {
            Admin superAdmin = new Admin("Keidy", "Keith", SuperAdmin, "vbiblio@gmail.com", 71963154, "vbiblio", "qwerty12", "", null, false);
            adminRepository.save(superAdmin);
        }
    }
}

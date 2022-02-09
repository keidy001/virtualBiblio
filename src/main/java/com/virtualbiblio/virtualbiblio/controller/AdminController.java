package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.repository.AdminRepository;
import com.virtualbiblio.virtualbiblio.service.AdminService;
import com.virtualbiblio.virtualbiblio.serviceImpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("admin")
    public String ajoutAdmin(@RequestBody Admin admin) {
        return adminService.ajoutAdmin(admin);
    }
    @GetMapping("admin/{id}")
    public Admin afficheAdminById(@PathVariable("id") Long id) {
        return adminService.afficheAdminById(id);
    }
    @GetMapping("admin")
    public List<Admin> afficheAdmin() {
        return adminService.afficheAdmin();
    }
    @PutMapping("admin/{id}")
    public Admin modifierAdmin(@RequestBody Admin admin, @PathVariable("id")Long id) {
        return adminService.modifierAdmin(admin, id);
    }
    @DeleteMapping("/admin/{id}")
    public Void deleteAdmin(@PathVariable("id") Long id) {
        return adminService.deleteAdmin(id);
    }
    @PutMapping("/desable/{id}")
    public Admin desable(@PathVariable Long id) {
        return adminService.disable(id);
    }
    @PutMapping("/restore{id}")
    public Admin restore(@PathVariable Long id) {
        return adminService.restore(id);
    }
}

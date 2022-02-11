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
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/ajouter")
    public String ajoutAdmin(@RequestBody Admin admin) {
        return adminService.ajoutAdmin(admin);
    }
    @GetMapping("/afficher/{id}")
    public Admin afficheAdminById(@PathVariable("id") Long id) {
        return adminService.afficheAdminById(id);
    }
    @GetMapping("/lister")
    public List<Admin> afficheAdmin() {
        return adminService.afficheAdmin();
    }
    @PutMapping("/modifier/{id}")
    public Admin modifierAdmin(@RequestBody Admin admin, @PathVariable("id")Long id) {
        return adminService.modifierAdmin(admin, id);
    }
    @DeleteMapping("/supprimer/{id}")
    public Void deleteAdmin(@PathVariable("id") Long id) {
        return adminService.deleteAdmin(id);
    }
    @PutMapping("/disable/{id}")
    public Admin disable(@PathVariable Long id) {
        return adminService.disable(id);
    }
    @PutMapping("/restore{id}")
    public Admin restore(@PathVariable Long id) {
        return adminService.restore(id);
    }
    @GetMapping("/login")
    public Admin login(@RequestParam String login, @RequestParam String password) {
        return adminService.login(login, password);
    }
}

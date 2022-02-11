package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
     String ajoutAdmin(Admin admin);
     Admin afficheAdminById(Long id);
     List<Admin> afficheAdmin();
     Admin modifierAdmin(Admin admin, Long id);
     Void deleteAdmin(Long id);
     Admin disable(Long id);
     Admin restore(Long id);
     Admin login(String login, String password);

}

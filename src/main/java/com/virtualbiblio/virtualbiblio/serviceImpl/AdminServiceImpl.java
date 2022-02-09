package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.repository.AdminRepository;
import com.virtualbiblio.virtualbiblio.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public String ajoutAdmin(Admin admin) {
        adminRepository.save(admin);
        return null;
    }

    @Override
    public Admin afficheAdminById(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<Admin> afficheAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin modifierAdmin(Admin admin, Long id) {
        Admin updateAdmin =  adminRepository.findById(id).get();
        updateAdmin.setNom(admin.getNom());
        updateAdmin.setPrenom(admin.getPrenom());
        updateAdmin.setEmail(admin.getEmail());
        updateAdmin.setTelephone(admin.getTelephone());
        updateAdmin.setLogin(admin.getLogin());
        updateAdmin.setPassword(admin.getPassword());
        return adminRepository.save(updateAdmin);
    }

    @Override
    public Void deleteAdmin(Long id) {

        adminRepository.deleteById(id);
        return null;
    }

    @Override
    public Admin disable(Long id) {
        Admin delete = adminRepository.findById(id).get();
        delete.setDelleted(true);
        return adminRepository.save(delete);
    }
    @Override
    public Admin restore(Long id) {
        Admin delete = adminRepository.findById(id).get();
        delete.setDelleted(false);
        return adminRepository.save(delete);
    }
}

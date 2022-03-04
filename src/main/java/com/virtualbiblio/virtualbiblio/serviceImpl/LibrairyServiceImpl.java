package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.Librairy;
import com.virtualbiblio.virtualbiblio.repository.AdminRepository;
import com.virtualbiblio.virtualbiblio.repository.LibrairyRepository;
import com.virtualbiblio.virtualbiblio.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibrairyServiceImpl implements LibrairyService {
    @Autowired
    LibrairyRepository librairyRepository;
    @Autowired
    AdminRepository adminRepository;
    @Override
    public String ajoutLibbrairy(Librairy librairy) {
        librairyRepository.save(librairy);
        return "success";
    }

    @Override
    public Librairy afficheLibrairy(Long id) {
        return librairyRepository.findById(id).get();
    }

    @Override
    public List<Librairy> listLibrairy() {
        return librairyRepository.findAll();
    }

    @Override
    public Librairy updateLibrairy(Librairy librairy, Long id) {

        Librairy updateLibrairy = librairyRepository.findById(id).get();
        updateLibrairy.setNom(updateLibrairy.getNom());
        updateLibrairy.setLivre(updateLibrairy.getLivre());
        updateLibrairy.setEmail(updateLibrairy.getEmail());
        updateLibrairy.setTelephone(updateLibrairy.getTelephone());
        updateLibrairy.setAdresse(updateLibrairy.getAdresse());
        return librairyRepository.save(updateLibrairy);
    }

    @Override
    public Void delete(Long id) {
        librairyRepository.deleteById(id);
        return null;
    }

    @Override
    public Librairy disable(Long id) {
        Librairy disable =librairyRepository.findById(id).get();
        disable.setDeleted(true);
        return  librairyRepository.save(disable);
    }

    @Override
    public Librairy restore(Long id) {
        Librairy restore = librairyRepository.findById(id).get();
        restore.setDeleted(false);
        return librairyRepository.save(restore);
    }
    @Override
    public List<Librairy> listByDeleted(Boolean deleted) {
        return librairyRepository.findByDeleted(deleted);
    }

}

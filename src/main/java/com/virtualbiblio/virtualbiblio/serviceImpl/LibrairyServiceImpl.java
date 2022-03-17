package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.Librairy;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.repository.AdminRepository;
import com.virtualbiblio.virtualbiblio.repository.LibrairyRepository;
import com.virtualbiblio.virtualbiblio.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
public class LibrairyServiceImpl implements LibrairyService {
    @Autowired
    LibrairyRepository librairyRepository;
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Librairy ajoutLibbrairy(Librairy librairy) {
        return librairyRepository.save(librairy);

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
        updateLibrairy.setNom(librairy.getNom());
        updateLibrairy.setLivre(librairy.getLivre());
        updateLibrairy.setEmail(librairy.getEmail());
        updateLibrairy.setTelephone(librairy.getTelephone());
        updateLibrairy.setAdresse(librairy.getAdresse());

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

    @Override
    public byte[] getPhoto(Long id) throws IllegalStateException, IOException {
        Librairy photo = librairyRepository.findById(id).get();
        String livrePhoto =photo.getPhoto();
        File file = new File("src/main/resources/librairy/images/"+photo.getIdLibrairy()+"/"+livrePhoto);
        Path path = Paths.get(file.toURI());
        return  Files.readAllBytes(path);
    }
}

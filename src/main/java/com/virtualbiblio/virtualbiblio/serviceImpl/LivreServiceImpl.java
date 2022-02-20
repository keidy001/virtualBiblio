package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.repository.LivreRepository;
import com.virtualbiblio.virtualbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceImpl implements LivreService {
    @Autowired
    LivreRepository livreRepository;
    @Override
    public Livre ajouter(Livre livre) {
        return    livreRepository.save(livre);

    }

    @Override
    public Livre afficher(Long id) {
        return livreRepository.findById(id).get();
    }

    @Override
    public List<Livre> lister() {
        return livreRepository.findAll();
    }

    @Override
    public Livre update(Livre livre, Long id) {
        Livre updateLivre = livreRepository.findById(id).get();
        updateLivre.setTitre(updateLivre.getTitre());
        updateLivre.setAuteur(updateLivre.getAuteur());
        updateLivre.setCategory(updateLivre.getCategory());
        updateLivre.setDomaine(updateLivre.getDomaine());
        updateLivre.setFormat(updateLivre.getFormat());
        updateLivre.setSommaire(updateLivre.getSommaire());
        updateLivre.setPrix(updateLivre.getPrix());
        return livreRepository.save(livre);
    }

    @Override
    public Void delete(Long id) {
        livreRepository.deleteById(id);
        return null;
    }

    @Override
    public Livre disable(Long id) {
        Livre delete = livreRepository.findById(id).get();
        delete.setDeleted(true);
        return livreRepository.save(delete);
    }

    @Override
    public Livre restore(Long id) {
        Livre restore = livreRepository.findById(id).get();
        restore.setDeleted(false);
        return livreRepository.save(restore);
    }

    @Override
    public Collection<Livre> findByState(int state) {
        return livreRepository.findByDeleted(state);
    }

    @Override
    public Collection<Livre> Format(Format format) {
        return livreRepository.findByFormat(format);
    }

@PostMapping
 public void uplodFile(MultipartFile file) throws IllegalStateException, IOException {
  file.transferTo(new File("C:\\Users\\Ghost\\Downloads\\"+file.getOriginalFilename()));
 }

    @Override
    public byte[] getPhoto(Long id) throws IllegalStateException, IOException {
        Livre photo = livreRepository.findById(id).get();
        String livrePhoto =photo.getPhoto();
        File file = new File("src/main/resources/images/"+photo.getIdLivre()+"/"+livrePhoto);
        Path path = Paths.get(file.toURI());
        return  Files.readAllBytes(path);
    }



    @Override
    public byte[] getPdf(Long id) throws  IOException {

        Livre livre = livreRepository.findById(id).get();
        String livreFile = livre.getLivre();
        File file = new File("src/main/resources/images/"+livre.getIdLivre()+"/" +livreFile);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

}
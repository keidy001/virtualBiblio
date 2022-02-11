package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.repository.LivreRepository;
import com.virtualbiblio.virtualbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceImpl implements LivreService {
    @Autowired
    LivreRepository livreRepository;
    @Override
    public String ajouter(Livre livre) {
        livreRepository.save(livre);
        return null;
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
        Livre disable = livreRepository.findById(id).get();
        disable.setDelleted(true);
        return null;
    }

    @Override
    public Livre restore(Long id) {
        Livre restore = livreRepository.findById(id).get();
        restore.setDelleted(false);
        return null;
    }

    @Override
    public Collection<Livre> Format(Format format) {
        return livreRepository.findByFormat(format);
    }
}

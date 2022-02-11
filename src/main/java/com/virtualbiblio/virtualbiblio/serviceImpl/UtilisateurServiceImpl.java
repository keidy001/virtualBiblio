package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.Utilisateur;
import com.virtualbiblio.virtualbiblio.repository.UtilisateurRepository;
import com.virtualbiblio.virtualbiblio.service.UtilisateurService;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Override
    public String ajoutUtilisateur(Utilisateur utilisateur) {
         utilisateurRepository.save(utilisateur);
         return "success";
    }

    @Override
    public Utilisateur afficheUtilisateur(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public List<Utilisateur> listUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id) {
        Utilisateur updateUtilisateur = utilisateurRepository.findById(id).get();

        updateUtilisateur.setNom(updateUtilisateur.getNom());
        updateUtilisateur.setPrenom(updateUtilisateur.getPrenom());
        updateUtilisateur.setEmail(updateUtilisateur.getEmail());
        updateUtilisateur.setLogin(updateUtilisateur.getLogin());
        updateUtilisateur.setTelephone(updateUtilisateur.getTelephone());
        updateUtilisateur.setPassword(updateUtilisateur.getPassword());
        updateUtilisateur.setProfile(updateUtilisateur.getProfile());
        return utilisateurRepository.save(updateUtilisateur);
    }

    @Override
    public Void deleteUtilisateur(Long id) {
            utilisateurRepository.deleteById(id);
        return null;
    }

    @Override
    public Utilisateur disable(Long id) {
        Utilisateur disable = utilisateurRepository.findById(id).get();
        disable.setDelleted(true);
        return null;
    }

    @Override
    public Utilisateur restore(Long id) {
        Utilisateur restore = utilisateurRepository.findById(id).get();
        restore.setDelleted(false);
        return null;
    }

    @Override
    public Utilisateur login(String login, String password) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByLoginAndPassword(login,password);

        if(utilisateur.isEmpty())
        {
            return null;
        }

        if(utilisateur.get().isDelleted())
        {
            throw new IllegalStateException("Votre compte administrateur est désactivé !");
        }

        return utilisateur.get();
    }
}

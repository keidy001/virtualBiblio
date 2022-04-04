package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.model.Utilisateur;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UtilisateurService {

    String ajoutUtilisateur(Utilisateur utilisateur);
    Utilisateur afficheUtilisateur(Long id);
    List<Utilisateur> listUtilisateur();
    Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id);
    Void deleteUtilisateur(Long id);
    Utilisateur disable(Long id);
    Utilisateur restore(Long id);
    Utilisateur login(String login, String password);
    List<Utilisateur> listByDeleted(Boolean deleted);
    Utilisateur resetpassword(String email);
    Utilisateur changePassword(Long id, Utilisateur utilisateur);

}

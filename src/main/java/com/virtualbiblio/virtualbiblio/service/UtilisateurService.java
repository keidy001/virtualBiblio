package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    String ajoutUtilisateur(Utilisateur utilisateur);
    Utilisateur afficheUtilisateur(Long id);
    List<Utilisateur> listUtilisateur();
    Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id);
    Void deleteUtilisateur(Long id);
    Utilisateur disable(Utilisateur utilisateur, Long id);
    Utilisateur restore(Utilisateur utilisateur, Long id);
}

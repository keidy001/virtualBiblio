package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Utilisateur;
import com.virtualbiblio.virtualbiblio.repository.UtilisateurRepository;
import com.virtualbiblio.virtualbiblio.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;
    @PostMapping("/ajouter")
    public String ajoutUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.ajoutUtilisateur(utilisateur);
    }
    @GetMapping("/afficher/{id}")
    public Utilisateur afficheUtilisateur(Long id) {
        return utilisateurService.afficheUtilisateur(id);
    }
    @GetMapping("/lister")
    public List<Utilisateur> listUtilisateur() {
        return utilisateurService.listUtilisateur();
    }
    @PutMapping("/modifier/{id}")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable("id") Long id) {
        return utilisateurService.updateUtilisateur(utilisateur, id);
    }
    @DeleteMapping("/supprimer/{id}")
    public Void deleteUtilisateur(@PathVariable("id") Long id) {
        return utilisateurService.deleteUtilisateur(id);
    }
    @PutMapping("/disable/{id}")
    public Utilisateur disable(@RequestBody Utilisateur utilisateur, @PathVariable("id") Long id) {
        return utilisateurService.disable(utilisateur, id);
    }
    @PutMapping("/restore")
    public Utilisateur restore(Utilisateur utilisateur, Long id) {
        return utilisateurService.restore(utilisateur, id);
    }
}

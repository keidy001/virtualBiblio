package com.virtualbiblio.virtualbiblio.repository;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByLoginAndPassword(String login, String password);
    List<Utilisateur> findByDeleted(Boolean deleted);
    Optional<Utilisateur>findByEmail(String email);

}

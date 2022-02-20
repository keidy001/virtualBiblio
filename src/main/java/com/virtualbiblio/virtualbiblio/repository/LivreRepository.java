package com.virtualbiblio.virtualbiblio.repository;

import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    //(value = "SELECT types FROM Livre types WHERE types.format=:types ")
    //Optional<Livre> findByFormat(@Param("types") String types);
    Collection<Livre> findByFormat(Format format);
    Collection<Livre> findByDeleted(int state);
}

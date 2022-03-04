package com.virtualbiblio.virtualbiblio.repository;

import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.model.Librairy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrairyRepository extends JpaRepository<Librairy, Long> {
    List<Librairy> findByDeleted(Boolean deleted);

}

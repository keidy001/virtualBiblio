package com.virtualbiblio.virtualbiblio.repository;

import com.virtualbiblio.virtualbiblio.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentsRepository extends JpaRepository<Documents, Long>{
List<Documents> findByDeleted(Boolean deleted);
}

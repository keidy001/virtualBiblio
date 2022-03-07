package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Documents;
import com.virtualbiblio.virtualbiblio.model.Librairy;

import java.util.List;

public interface DocumentsService {
    Documents ajoutDocuments(Documents documents);
    Documents afficheDocuments(Long id);
    List<Documents> listDocuments();
    Documents updateDocuments(Documents documents, Long id);
    Void delete(Long id);
    Documents disable(Long id);
    Documents restore(Long id);
    List<Documents> listByDeleted(Boolean deleted);
}

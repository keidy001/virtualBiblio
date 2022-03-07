package com.virtualbiblio.virtualbiblio.serviceImpl;

import com.virtualbiblio.virtualbiblio.model.Documents;
import com.virtualbiblio.virtualbiblio.model.Documents;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.repository.DocumentsRepository;
import com.virtualbiblio.virtualbiblio.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentsServiceImpl implements DocumentsService {
    @Autowired
    DocumentsRepository documentsRepository;

    @Override
    public Documents ajoutDocuments(Documents documents) {
        return documentsRepository.save(documents);
    }

    @Override
    public Documents afficheDocuments(Long id) {
        return documentsRepository.findById(id).get();
    }

    @Override
    public List<Documents> listDocuments() {
        return documentsRepository.findAll();
    }

    @Override
    public Documents updateDocuments(Documents documents, Long id) {
        Documents updateDocuments = documentsRepository.findById(id).get();
        updateDocuments.setTitre(updateDocuments.getTitre());
        updateDocuments.setAuteur(updateDocuments.getAuteur());
        updateDocuments.setCategory(updateDocuments.getCategory());
        updateDocuments.setDescriptoion(updateDocuments.getDescriptoion());
        updateDocuments.setTypes(updateDocuments.getTypes());
        updateDocuments.setDocuments(updateDocuments.getDocuments());
        updateDocuments.setAdmin(updateDocuments.getAdmin());
        return documentsRepository.save(updateDocuments);
    }

    @Override
    public Void delete(Long id) {
        documentsRepository.deleteById(id);
        return null;
    }

    @Override
    public Documents disable(Long id) {
        Documents delete = documentsRepository.findById(id).get();
        delete.setDeleted(true);
        return documentsRepository.save(delete);
    }

    @Override
    public Documents restore(Long id) {
        Documents restore = documentsRepository.findById(id).get();
        restore.setDeleted(false);
        return documentsRepository.save(restore);
    }

    @Override
    public List<Documents> listByDeleted(Boolean deleted) {
        return documentsRepository.findByDeleted(deleted);
    }
}

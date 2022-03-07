package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Documents;
import com.virtualbiblio.virtualbiblio.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/documents")
public class DocumentsController {

    @Autowired
    DocumentsService documentsService;
    @PostMapping("/ajouter")
    public Documents ajoutDocuments(@RequestBody Documents documents) {
        return documentsService.ajoutDocuments(documents);
    }
    @GetMapping("/afficher/{id}")
    public Documents afficheDocuments(@PathVariable("id") Long id) {
        return documentsService.afficheDocuments(id);
    }
    @GetMapping("/lister")
    public List<Documents> listDocuments() {
        return documentsService.listDocuments();
    }
    @PutMapping("/modifier/{id}")
    public Documents updateDocuments(Documents documents,@PathVariable("id")  Long id) {
        return documentsService.updateDocuments(documents, id);
    }
    @DeleteMapping("/supprimer/{id}")
    public Void delete(@PathVariable("id") Long id) {
        return documentsService.delete(id);
    }
    @PutMapping("/disable/{id}")
    public Documents disable(@PathVariable("id") Long id) {
        return documentsService.disable(id);
    }
    @PutMapping("/restore/{id}")
    public Documents restore(@PathVariable("id") Long id) {
        return documentsService.restore(id);
    }
    @GetMapping("/byStatus/{state}")
    public List<Documents> listByDeleted(@PathVariable("state") Boolean deleted) {
        return documentsService.listByDeleted(deleted);
    }
}

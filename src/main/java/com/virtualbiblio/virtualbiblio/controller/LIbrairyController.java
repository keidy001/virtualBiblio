package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Librairy;
import com.virtualbiblio.virtualbiblio.repository.LibrairyRepository;
import com.virtualbiblio.virtualbiblio.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/librairy")
public class LIbrairyController {
    @Autowired
    LibrairyService librairyService;
    @PostMapping("/ajouter")
    public String ajoutLibbrairy(@RequestBody Librairy librairy) {
        return librairyService.ajoutLibbrairy(librairy);
    }
    @GetMapping("/afficher/{id}")
    public Librairy afficheLibrairy(Long id) {
        return librairyService.afficheLibrairy(id);
    }
    @GetMapping("/lister")
    public List<Librairy> listLibrairy() {
        return librairyService.listLibrairy();
    }
    @PutMapping("/modifier/{id}")
    public Librairy updateLibrairy(@RequestBody Librairy librairy, @PathVariable("id") Long id) {
        return librairyService.updateLibrairy(librairy, id);
    }
    @DeleteMapping("/supprimer/{id}")
    public Void delete(@PathVariable("id") Long id) {
        return librairyService.delete(id);
    }
    @PutMapping("/disable/{id}")
    public Librairy disable(@PathVariable("id") Long id) {
        return librairyService.disable(id);
    }
    @PutMapping("/restore{id}")
    public Librairy restore(@PathVariable("id") Long id) {
        return librairyService.restore(id);
    }
}

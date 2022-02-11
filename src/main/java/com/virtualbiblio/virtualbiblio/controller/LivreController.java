package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/livre")
public class LivreController {
    @Autowired
    LivreService livreService;

    @PostMapping("/ajouter")
    public String ajouter(@RequestBody Livre livre) {
        return livreService.ajouter(livre);
    }
    @GetMapping("/afficher/{id}")
    public Livre afficher(@PathVariable("id") Long id) {
        return livreService.afficher(id);
    }
    @GetMapping("/lister")
    public List<Livre> lister() {
        return livreService.lister();
    }
    @PutMapping("/modifier/{id}")
    public Livre update(@RequestBody Livre livre, @PathVariable("id") Long id) {
        return livreService.update(livre, id);
    }
    @DeleteMapping("/supprimer/{id}")
    public Void delete(@PathVariable("id") Long id) {
        return livreService.delete(id);
    }
    @PutMapping("/disable/{id}")
    public Livre disable(@PathVariable("id") Long id) {
        return livreService.disable(id);
    }
    @PutMapping("/restore/{id}")
    public Livre restore(@PathVariable("id") Long id) {
        return livreService.restore(id);
    }
    @GetMapping("/livrebyformat/{format}")
    public Collection<Livre> Format(@PathVariable("format") Format format) {
        return livreService.Format(format);
    }
}

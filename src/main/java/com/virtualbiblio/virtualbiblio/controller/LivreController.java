package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/livre")
public class LivreController {
    @Autowired
    LivreService livreService;

    @PostMapping(value= "/ajouter", consumes = { MediaType. APPLICATION_JSON_VALUE ,MediaType. MULTIPART_FORM_DATA_VALUE })
    public String ajouter(@RequestParam("file") @RequestBody Livre livre,MultipartFile file) throws  IllegalStateException, IOException  {
        livreService.uplodFile(file);
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
    @GetMapping("/ /{format}")
    public Collection<Livre> Format(@PathVariable("format") Format format) {
        return livreService.Format(format);
    }
    @PostMapping("file")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
            livreService.uplodFile(file);
    }
}

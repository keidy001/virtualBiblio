package com.virtualbiblio.virtualbiblio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.model.Response;
import com.virtualbiblio.virtualbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/ajouter")
    public ResponseEntity<Response> savedata(@RequestParam("file") MultipartFile file ,@RequestParam("data") String data) throws  IllegalStateException, IOException  {
        Livre livre = new ObjectMapper().readValue(data, Livre.class);
        livre.setPhoto(file.getBytes());
        livre.setPhotoName(file.getOriginalFilename());
        Livre dblivre = livreService.ajouter(livre);
        if (dblivre!=null){
            return new ResponseEntity<Response>(new Response("Ajout effectuer avec succès"), HttpStatus.OK);
        } else {
            return new ResponseEntity<Response>(new Response("Erreur lors de l'ajout"), HttpStatus.OK);

        }
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
    @PostMapping("file")
    public void uploadFile( Livre livre,  @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
            livreService.uplodFile(file);
    }
}

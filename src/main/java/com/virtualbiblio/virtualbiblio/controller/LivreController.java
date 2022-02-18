package com.virtualbiblio.virtualbiblio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtualbiblio.virtualbiblio.model.File;
import com.virtualbiblio.virtualbiblio.model.Format;
import com.virtualbiblio.virtualbiblio.model.Livre;
import com.virtualbiblio.virtualbiblio.model.Response;
import com.virtualbiblio.virtualbiblio.service.LivreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
    @ResponseBody
<<<<<<< HEAD
        public livre ajouterLIvre(Livre livre,
=======
        public Livre ajouterLIvre(Livre livre,
>>>>>>> 9fe5f89f85ad91abe172f394a4168508a02cd8ac
                                   @RequestParam("file") MultipartFile img,
                                   @RequestParam("pdf") MultipartFile pdf)
            throws IOException {
        //Methode for upload photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        livre.setPhoto(fileNamePhoto);
        String uploadDirPhoto = "src/main/resources/images/" ;
        System.out.println(livre.getIdLivre());
        File.saveFile(uploadDirPhoto, fileNamePhoto, img);
        //Methode for upload livre
        String fileNamePdf = StringUtils.cleanPath(pdf.getOriginalFilename());
        livre.setLivre(fileNamePdf);
        String uploadDirPdf = "src/main/resources/livre/";
        //Methode for save data
        File.saveFile(uploadDirPdf, fileNamePdf, pdf);
<<<<<<< HEAD

        return  this.livreService.ajouter(livre);
=======
       return  this.livreService.ajouter(livre);
>>>>>>> 9fe5f89f85ad91abe172f394a4168508a02cd8ac
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
    @GetMapping("/ format/{format}")
    public Collection<Livre> Format(@PathVariable("format") Format format) {
        return livreService.Format(format);
    }
    @PostMapping("file")
    public void uploadFile( Livre livre,  @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
            livreService.uplodFile(file);
    }

    @GetMapping(value = "/photo/{photo}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo") Long id) throws IOException{
        livreService.getPhoto(id);
         return null;
    };


}

package com.virtualbiblio.virtualbiblio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtualbiblio.virtualbiblio.model.*;
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
        public Livre ajouterLIvre(Livre livre,
                                   @RequestParam("file") MultipartFile img,
                                   @RequestParam("pdf") MultipartFile pdf)
            throws IOException {
        //Methode for upload photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        livre.setPhoto(fileNamePhoto);
        livreService.ajouter(livre);
        String uploadDirPhoto = "src/main/resources/images/"+livre.getIdLivre() ;

        File.saveFile(uploadDirPhoto, fileNamePhoto, img);
        //Methode for upload livre
        String fileNamePdf = StringUtils.cleanPath(pdf.getOriginalFilename());
        livre.setLivre(fileNamePdf);
        livreService.ajouter(livre);
        String uploadDirPdf = "src/main/resources/livre/"+livre.getIdLivre();
        File.saveFile(uploadDirPdf, fileNamePdf, pdf);
        //Methode for save data
        return  this.livreService.ajouter(livre);

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
    public Collection<Livre> Format(@PathVariable("format")     Format format) {
        return livreService.Format(format);
    }
    @PostMapping("file")
    public void uploadFile( Livre livre,  @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
            livreService.uplodFile(file);
    }

    @GetMapping(value = "/photo/{photo}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo") Long id) throws IOException{

         return livreService.getPhoto(id);
    };

    @GetMapping(value = "/livre/{livre}", produces = {MediaType.APPLICATION_PDF_VALUE})

    byte[] getPdf(@PathVariable("livre") Long id) throws IOException{

        return livreService.getPdf(id);
    };

    @GetMapping(value = "/audio/{audio}", produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})

    byte[] audio(@PathVariable("audio") Long id) throws IOException{

        return livreService.getPdf(id);
    };


    @GetMapping("/byStatus/{state}")
    public List<Livre> listByDeleted(@PathVariable("state") Boolean deleted) {
        return livreService.listByDeleted(deleted);
    }
    @GetMapping("/formatNotDeleleted/{format}/{state}")
    public List<Livre> findByFormatAndDeleted(@PathVariable("format") Format format,@PathVariable("state") Boolean state) {
        return livreService.findByFormatAndDeleted(format, state);
    }
@GetMapping("/bycat/{format}/{category}/{state}")
    public List<Livre> listByFormatAndCategoryAndDeleted(@PathVariable("format") Format format,@PathVariable("category") Category category, @PathVariable("state") Boolean deleted) {
        return livreService.listByFormatAndCategoryAndDeleted(format, category, deleted);
    }
@GetMapping("/livreByLibrairy/{library}/{state}")
    public List<Livre> livreByLibrairy(@PathVariable("library") Librairy librairy, @PathVariable("state") Boolean deleted) {
        return livreService.livreByLibrairy(librairy, deleted);
    }

}

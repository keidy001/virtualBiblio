package com.virtualbiblio.virtualbiblio.controller;

import com.virtualbiblio.virtualbiblio.model.Admin;
import com.virtualbiblio.virtualbiblio.model.File;
import com.virtualbiblio.virtualbiblio.model.Librairy;
import com.virtualbiblio.virtualbiblio.repository.LibrairyRepository;
import com.virtualbiblio.virtualbiblio.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/librairy")
public class LibrairyController {
    @Autowired

    LibrairyService librairyService;
    @PostMapping("/ajouter")

    @ResponseBody
    public Librairy ajoutLibbrairy(Librairy librairy,
                                 @RequestParam("file") MultipartFile img)
            throws IOException {
        //Methode for upload photo
        String fileNamePhoto = StringUtils.cleanPath(img.getOriginalFilename());
        librairy.setPhoto(fileNamePhoto);
        librairyService.ajoutLibbrairy(librairy);
        String uploadDirPhoto = "src/main/resources/librairy/images/"+librairy.getIdLibrairy() ;
        File.saveFile(uploadDirPhoto, fileNamePhoto, img);
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
    @GetMapping("/byStatus/{state}")
    public List<Librairy> listByDeleted(@PathVariable("state") Boolean deleted) {
        return librairyService.listByDeleted(deleted);
    }
    @GetMapping(value = "/photo/{photo}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})

    byte[] getPhoto(@PathVariable("photo") Long id) throws IOException{

        return librairyService.getPhoto(id);
    };


}

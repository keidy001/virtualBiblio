package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Category;
import com.virtualbiblio.virtualbiblio.model.Librairy;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface LibrairyService {
    Librairy ajoutLibbrairy(Librairy librairy);
    Librairy afficheLibrairy(Long id);
    List<Librairy> listLibrairy();
    Librairy updateLibrairy(Librairy librairy, Long id);
    Void delete(Long id);
    Librairy disable(Long id);
    Librairy restore(Long id);
    List<Librairy> listByDeleted(Boolean deleted);
    byte[] getPhoto(Long id) throws IllegalStateException, IOException;


}

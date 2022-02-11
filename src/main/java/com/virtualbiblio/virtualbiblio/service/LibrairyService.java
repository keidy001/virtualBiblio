package com.virtualbiblio.virtualbiblio.service;

import com.virtualbiblio.virtualbiblio.model.Librairy;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibrairyService {
    String ajoutLibbrairy(Librairy librairy);
    Librairy afficheLibrairy(Long id);
    List<Librairy> listLibrairy();
    Librairy updateLibrairy(Librairy librairy, Long id);
    Void delete(Long id);
    Librairy disable(Long id);
    Librairy restore(Long id);

}

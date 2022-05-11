package com.api.Visiteur.files.repository;

import com.api.Visiteur.entities.User2;
import com.api.Visiteur.files.model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileUploadRepossitory extends JpaRepository<UploadFile,Long> {
    UploadFile findByFileName(String fileName);

}

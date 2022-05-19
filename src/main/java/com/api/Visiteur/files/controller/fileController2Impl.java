package com.api.Visiteur.files.controller;


import com.api.Visiteur.files.dto.UploadFileDto;
import com.api.Visiteur.files.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class fileController2Impl implements  fileController2  {

   @Autowired
   private FileUploadService fileUploadService;
    @Override
    public List<UploadFileDto> findAll() {
        return fileUploadService.listfiles();
    }
}

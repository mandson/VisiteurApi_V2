package com.api.Visiteur.files.controller;

import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.files.model.UploadFile;
import com.api.Visiteur.files.repository.FileUploadRepossitory;
import com.api.Visiteur.files.service.FileUploadService;
import com.api.Visiteur.web.controller.VisiteCategorieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("api")
public class fileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private FileUploadRepossitory fileUploadRepossitory;
    @PostMapping("/upload/local")
    public void upload(@RequestParam("file")MultipartFile multipartFile){
            fileUploadService.uploadToLocal(multipartFile);
    }




    @PostMapping("/upload/db")
    public void uploadDb(@RequestParam("file")MultipartFile multipartFile){
            fileUploadService.uploadToDb(multipartFile);
            fileUploadService.uploadToLocal(multipartFile);

    }


    //Methode de lecture des images
    @GetMapping(path="/download/local/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] images(@PathVariable(name ="id") Long id) throws Exception{
        UploadFile f = fileUploadRepossitory.findById(id).get();
        String photoName = f.getFileName();
        //chemin d'acces externe des images

        File file = new File(System.getProperty("user.home")+"/Pictures/uploaded/"+photoName);

        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    //Methode de lecture des images
    @GetMapping(path="/download/filename/{filename}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] images(@PathVariable(name ="filename") String filename) throws Exception{
        UploadFile fs = fileUploadRepossitory.findByFileName(filename);
        String photoName = fs.getFileName();
        //chemin d'acces externe des images
        File file = new File(System.getProperty("user.home")+"/Pictures/uploaded/"+photoName);

        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }


}

package com.api.Visiteur;

import com.api.Visiteur.dto.FileUploadResponse;
import com.api.Visiteur.services.serviceImpl.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UploadDownloadWithFileSystemController {
    private FileStorageService fileStorageService;

    public UploadDownloadWithFileSystemController(FileStorageService fileStorageService) {

        this.fileStorageService = fileStorageService;
    }

    @PostMapping("single/upload")
    FileUploadResponse singleUpload(@RequestParam("file") MultipartFile file){
           String fileName = fileStorageService.storeFile(file);
           String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                   .path("/download/")
                   .path(fileName)
                   .toUriString();
            String contentType =file.getContentType();

           FileUploadResponse response = new FileUploadResponse(fileName,contentType,url);
        return  response;
    }

    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource>downloadSingleFile(@PathVariable String fileName){
       Resource resource  = fileStorageService.downloadFile(fileName);
       MediaType contentType = MediaType.IMAGE_PNG ;
       return  ResponseEntity.ok()
               .contentType(contentType)
              // .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;fileName="+resource.getFilename())
        .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName="+resource.getFilename())
               .body(resource);

    }
}

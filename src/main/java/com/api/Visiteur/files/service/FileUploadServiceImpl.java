package com.api.Visiteur.files.service;

import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.files.dto.UploadFileDto;
import com.api.Visiteur.files.model.UploadFile;
import com.api.Visiteur.files.repository.FileUploadRepossitory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor @NoArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {
    private  String uploadFolderPath = "C:/Users/USER/Pictures/uploaded/";

    @Autowired
    private FileUploadRepossitory fileUploadRepossitory;
    @Override
    public void uploadToLocal(MultipartFile file) {
        try {
            byte[] data =file.getBytes();
            Path path = Paths.get(uploadFolderPath +file.getOriginalFilename().replaceAll(" ",""));
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void uploadToDb(MultipartFile file) {
        UploadFile uploadFile = new UploadFile();

        try {
            uploadFile.setFileuserId("userId:X");
            uploadFile.setFileData(uploadFile.getFileData());
            uploadFile.setFileType(file.getContentType());
            uploadFile.setFileName(file.getOriginalFilename().replaceAll(" ","-").replace("'","")) ;

            byte[] data =file.getBytes();
            Path path = Paths.get(uploadFolderPath +file.getOriginalFilename().replaceAll(" ","-").replace("'",""));
            Files.write(path,data);

            fileUploadRepossitory.save(uploadFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public UploadFile downloadFile(Long id) {
        UploadFile uploadedFileToRet=  fileUploadRepossitory.getById(id);
        return  uploadedFileToRet;
    }

    @Override
    public UploadFile downloadFileByFileName(String fileName) {
        UploadFile uploadedFileToRet=  fileUploadRepossitory.findByFileName(fileName);
        return  uploadedFileToRet;    }

    @Override
    public List<UploadFileDto> listfiles() {
        return fileUploadRepossitory.findAll().stream()

                .map(UploadFileDto::fromEntity)
                .collect(Collectors.toList())
                ;
    }


}

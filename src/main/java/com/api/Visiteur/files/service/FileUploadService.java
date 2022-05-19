package com.api.Visiteur.files.service;

import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.files.dto.UploadFileDto;
import com.api.Visiteur.files.model.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {


    public  void  uploadToLocal(MultipartFile file);
    public  void  uploadToDb(MultipartFile file);
    public UploadFile downloadFile(Long id);
    public UploadFile downloadFileByFileName(String fileName);

    List<UploadFileDto> listfiles();


}

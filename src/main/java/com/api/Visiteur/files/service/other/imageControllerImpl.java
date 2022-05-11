package com.api.Visiteur.files.service.other;

import com.api.Visiteur.files.dto.UploadFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class imageControllerImpl implements imageController {

    @Autowired
    ImageServe imageServe;
    @Override
    public List<UploadFileDto> findAll() {
        return imageServe.listFile();
    }
}

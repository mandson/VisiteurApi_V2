package com.api.Visiteur.files.controller;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.files.dto.UploadFileDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface fileController2 {
    //ici on consomme pas du json mais on retourne json
    @GetMapping(value =APP_ROOT+"/files/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<UploadFileDto> findAll();

}

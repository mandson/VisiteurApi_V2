package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.dto.VisiteCategorieDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface VisiteCategorieController {

    @GetMapping(value =APP_ROOT+"/categorievisite/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteCategorieDTO> listCategorieVisites();

    @PostMapping(value =APP_ROOT+"/categorievisite/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VisiteCategorieDTO save(@RequestBody VisiteCategorieDTO dto);


    @DeleteMapping(value =APP_ROOT+"/categorievisite/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/categorievisite/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<VisiteCategorieDTO> findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/categorievisite/edite/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

}

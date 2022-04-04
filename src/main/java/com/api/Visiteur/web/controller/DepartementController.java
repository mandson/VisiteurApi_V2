package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.EntrepriseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface DepartementController {
    //ici on consomme pas du json mais on retourne json
    @GetMapping(value =APP_ROOT+"/departement/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<DepartementDTO> findAll();

    @PostMapping(value =APP_ROOT+"/departement/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DepartementDTO save(@RequestBody DepartementDTO dto);

    @DeleteMapping(value =APP_ROOT+"/departement/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/departement/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<DepartementDTO> findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/departement/edite/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

}

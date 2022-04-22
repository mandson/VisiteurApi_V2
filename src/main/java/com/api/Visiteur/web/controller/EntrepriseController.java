package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.EntrepriseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface EntrepriseController {


    @GetMapping(value =APP_ROOT+"/entreprise/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<EntrepriseDTO> findAll();

    @PostMapping(value =APP_ROOT+"/entreprise/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO save(@RequestBody EntrepriseDTO dto);

    @DeleteMapping(value =APP_ROOT+"/entreprise/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/entreprise/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<EntrepriseDTO> findById(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/entreprise/find/ifu/{ifu}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<EntrepriseDTO> findByIfu(@PathVariable("ifu") String ifu);


    @GetMapping(value =APP_ROOT+"/entriprise/edite/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);


}

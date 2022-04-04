package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.entities.Personnel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.api.Visiteur.utils.constants.APP_ROOT;


public interface PersonnelController {
    @GetMapping(value =APP_ROOT+"/personnel/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<PersonnelDTO>listPersonnel();

    @PostMapping(value =APP_ROOT+"/personnel/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PersonnelDTO save(@RequestBody PersonnelDTO dto);


    @DeleteMapping(value =APP_ROOT+"/personnel/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/personnel/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<PersonnelDTO> findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/personnel/edite/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

}

package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.dto.VisiteurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface VisiteurController {
    @GetMapping(value =APP_ROOT+"/visiteur/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> listVisiteurs();

    @PostMapping(value =APP_ROOT+"/visiteur/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VisiteurDTO save(@RequestBody VisiteurDTO dto);


    @DeleteMapping(value =APP_ROOT+"/visiteur/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/visiteur/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<VisiteurDTO> findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/visiteur/edite/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

}

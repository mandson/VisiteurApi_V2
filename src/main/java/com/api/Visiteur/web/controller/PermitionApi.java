package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.PermitionDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface PermitionApi {
    @GetMapping(value =APP_ROOT+"/permition/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<PermitionDto> findAll();

    @PostMapping(value =APP_ROOT+"/permition/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PermitionDto save(@RequestBody PermitionDto dto);

    @GetMapping(value =APP_ROOT+"/permition/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    PermitionDto findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/permition/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);


    @DeleteMapping(value =APP_ROOT+"/permition/delete/{id}" )
    void delete(Long id);
}

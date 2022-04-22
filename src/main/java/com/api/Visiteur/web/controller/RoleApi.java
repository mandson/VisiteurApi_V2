package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.RoleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface RoleApi {
    @GetMapping(value =APP_ROOT+"/role/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<RoleDto> findAll();


    @PostMapping(value =APP_ROOT+"/role/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDto save(@RequestBody RoleDto dto);

    @GetMapping(value =APP_ROOT+"/role/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    RoleDto findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/role/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

    @DeleteMapping(value =APP_ROOT+"/role/delete/{id}" )
    void delete(Long id);
}

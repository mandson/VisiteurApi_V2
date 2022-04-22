package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.User2Dto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface UserApi {
    @GetMapping(value =APP_ROOT+"/user/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<User2Dto> findAll();

    @PostMapping(value =APP_ROOT+"/user/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User2Dto save(@RequestBody User2Dto dto);

    @GetMapping(value =APP_ROOT+"/user/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    User2Dto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/user/email/{email}/password/{password}",produces = MediaType.APPLICATION_JSON_VALUE )
    User2Dto findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password);

    @GetMapping(value=APP_ROOT+"/user/firstname/{firstname}",produces = MediaType.APPLICATION_JSON_VALUE )
    User2Dto findUserByFirstname( @PathVariable("firstname")  String firstname);

    @GetMapping(value=APP_ROOT+"/user/email/{email}",produces = MediaType.APPLICATION_JSON_VALUE )
    User2Dto findUserByEmail( @PathVariable("email")  String email );

    @GetMapping(value =APP_ROOT+"/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

    @GetMapping(value =APP_ROOT+"/user/liste/identreprise/{identreprise}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<User2Dto> findAllByidEntreprise(@PathVariable("identreprise") Long identreprise);


    @DeleteMapping(value =APP_ROOT+"/user/delete/{id}" )
    void delete(Long id);
}

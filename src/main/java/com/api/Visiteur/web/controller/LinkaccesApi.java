package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.LinkaccesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface LinkaccesApi {

    @GetMapping(value =APP_ROOT+"/linkacces/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<LinkaccesDto> findAll();

    @PostMapping(value =APP_ROOT+"/linkacces/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LinkaccesDto save(@RequestBody LinkaccesDto dto);

    @GetMapping(value =APP_ROOT+"/linkacces/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    LinkaccesDto findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/linkacces/role_permite/{idrole}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<LinkaccesDto>listePermitionByRole(@PathVariable("idrole") Long idrole);

    @GetMapping(value =APP_ROOT+"/linkacces/find/idrole/{idrole}/idpermition/{idpermition}",produces = MediaType.APPLICATION_JSON_VALUE )
    boolean findListeparIdRoleAndIdPermition(@PathVariable Long idrole, @PathVariable Long idpermition);

    @GetMapping(value =APP_ROOT+"/linkacces/find2/idrole/{idrole}/idpermition/{idpermition}",produces = MediaType.APPLICATION_JSON_VALUE )
    LinkaccesDto findOneByIdRoleAndIdPermition(@PathVariable Long idrole, @PathVariable Long idpermition);

    @GetMapping(value =APP_ROOT+"/linkacces/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

    @DeleteMapping(value =APP_ROOT+"/linkacces/delete/{id}" )
    void delete(Long id);
}

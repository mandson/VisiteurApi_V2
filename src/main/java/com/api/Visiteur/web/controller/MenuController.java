package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.dto.MenuDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface MenuController {
    @GetMapping(value =APP_ROOT+"/menu/acces/{access}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<MenuDTO> listeMenuByAccess(@PathVariable("access") String access);

}

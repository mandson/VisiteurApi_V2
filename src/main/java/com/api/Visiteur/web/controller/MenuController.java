package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.dto.MenuDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;
import java.util.List;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface MenuController {
    @GetMapping(value =APP_ROOT+"/menu/acces/{access}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<MenuDTO> listeMenuByAccess(@PathVariable("access") String access);

    @GetMapping(APP_ROOT+"/export/{format}")
    String exportReport(@PathVariable("format") String format) throws JRException, FileNotFoundException ;
}

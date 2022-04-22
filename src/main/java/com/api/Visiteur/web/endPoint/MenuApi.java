package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.services.DepartementService;
import com.api.Visiteur.services.MenueService;
import com.api.Visiteur.web.controller.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuApi implements MenuController {

    @Autowired
    MenueService menueService;

    public MenuApi(MenueService menueService) {
        this.menueService = menueService;
    }

    @Override
    public List<MenuDTO> listeMenuByAccess(String access) {
        return menueService.listMenuByAccess(access);
    }
}

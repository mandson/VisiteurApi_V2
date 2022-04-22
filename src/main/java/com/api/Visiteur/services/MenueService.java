package com.api.Visiteur.services;

import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.dto.RoleDto;

import java.util.List;

public interface MenueService {
    List<MenuDTO> listMenuByAccess(String access);

}

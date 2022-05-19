package com.api.Visiteur.services;

import com.api.Visiteur.dto.MenuDTO;
import com.api.Visiteur.dto.RoleDto;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface MenueService {
    List<MenuDTO> listMenuByAccess(String access);

    String exportReport(String format) throws FileNotFoundException, JRException;
}

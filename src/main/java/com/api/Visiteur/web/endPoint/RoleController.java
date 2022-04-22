package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.RoleDto;
import com.api.Visiteur.services.RoleService;
import com.api.Visiteur.web.controller.RoleApi;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
public class RoleController implements RoleApi {

    @Autowired
    RoleService roleService;

    @Override
    public List<RoleDto> findAll() {
        return roleService.listRole();
    }

    @Override
    public RoleDto save(RoleDto dto) {
        return roleService.save( dto );
    }

    @Override
    public RoleDto findById(Long id) {
        return null;
    }

    @Override
    public void modifier(Long id) {
        roleService.update( id );
    }

    @Override
    public void delete(Long id) {

        roleService.delete( id );
    }
}

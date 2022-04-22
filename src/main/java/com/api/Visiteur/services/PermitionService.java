package com.api.Visiteur.services;

import com.api.Visiteur.dto.PermitionDto;

import java.util.List;

public interface PermitionService {
    List<PermitionDto> listPermition();
    PermitionDto save(PermitionDto dto);
    PermitionDto findById(Long id);
    // RoleDto findByEmailAndPassword(String email,String password);
    void delete(Long id);
    void update(  Long id);
}

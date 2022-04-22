package com.api.Visiteur.services;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.User2Dto;

import java.util.List;

public interface UserService {

    List<User2Dto> listUser();
    User2Dto save(User2Dto dto);
    User2Dto findById(Long id);
    User2Dto findUserByEmailAndPassword (String email,String password);
    User2Dto findUserByFirstName (String firstName);
    User2Dto findUserByEmail (String email);
    List<User2Dto> listUserByIdEntreprise(Long idEntreprise);

    void delete(Long id);
    void update(  Long id);
    }
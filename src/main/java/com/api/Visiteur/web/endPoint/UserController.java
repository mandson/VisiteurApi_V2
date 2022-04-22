package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.services.UserService;
import com.api.Visiteur.web.controller.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController implements UserApi {
    @Autowired
    UserService userService;

    @Override
    public List<User2Dto> findAll() {
        return userService.listUser();
    }

    @Override
    public User2Dto save(User2Dto dto) {
        return userService.save( dto );
    }

    @Override
    public User2Dto findById(Long id) {
        return userService.findById( id );
    }

    @Override
    public User2Dto findUserByEmailAndPassword(String email, String password) {
        return userService.findUserByEmailAndPassword(email, password);
    }


    @Override
    public User2Dto findUserByFirstname(String firstname) {
        return userService.findUserByFirstName( firstname );
    }

    @Override
    public User2Dto findUserByEmail(String email ){
        return userService.findUserByEmail(email);
    }

    @Override
    public void modifier(Long id) {

    }

    @Override
    public List<User2Dto> findAllByidEntreprise(Long identreprise) {
        return userService.listUserByIdEntreprise(identreprise);
    }

    @Override
    public void delete(Long id) {
        userService.delete( id );
    }
}

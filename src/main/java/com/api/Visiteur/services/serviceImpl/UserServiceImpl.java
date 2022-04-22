package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.repository.UserRepository;
import com.api.Visiteur.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User2Dto> listUser() {

        return userRepository.findAll().stream()
                .map( User2Dto::fromEntity)
                .collect( Collectors.toList())
                ;    }

    @Override
    public User2Dto save(User2Dto dto) {

        return  User2Dto.fromEntity(
                userRepository.save(User2Dto.toEntity(dto))
        );
    }

    @Override
    public User2Dto findById(Long id) {

        if (id == null){
            return  null;
        }


        return userRepository.findById(id)
                .map(User2Dto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition avec l'ID = "+id+ "n'a ete trouver dans la base de BDD")
                );    }

    @Override
    public User2Dto findUserByEmailAndPassword(String email, String password) {


        User2Dto resp = userRepository.findUserByEmail(email) .map(User2Dto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition avec l'ID = "+password+ "n'a ete trouver dans la base de BDD")
                );

        if (resp.getPassword().equals(password)) {
            return resp;
        }
          else {
              return null;
        }
    }

    @Override
    public User2Dto findUserByFirstName(String firstName) {



        return userRepository.findUserByFirstName(firstName)
                .map(User2Dto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition avec l'ID = "+firstName+ "n'a ete trouver dans la base de BDD")
                );
    }

    @Override
    public User2Dto findUserByEmail(String email) {
        User2Dto verifuser = userRepository.findUserByEmail( email )

                .map( User2Dto::fromEntity )
                .orElseThrow( () -> new EntityNotFoundException(

                        "Aucune email avec= " + email + "n'a ete trouver dans la base de BDD" )
                );
        if (verifuser.getPassword().equals( "password" )){
            return verifuser;}
        else return null;
    }

    @Override
    public List<User2Dto> listUserByIdEntreprise(Long idEntreprise) {
        return userRepository.findUserByIdEntreprisef(idEntreprise).stream()
                .map(User2Dto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        userRepository.findById( id );
    }

    @Override
    public void update(Long id) {

    }
}

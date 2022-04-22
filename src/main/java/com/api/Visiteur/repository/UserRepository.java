package com.api.Visiteur.repository;

import com.api.Visiteur.entities.User;
import com.api.Visiteur.entities.User2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User2,Long> {
    List<User2> findUserByIdEntreprisef(Long idEntreprisef);

    Optional<User2> findUserByEmailAndPassword (String email, String password);
    Optional<User2> findUserByEmail(String email);
    Optional<User2> findUserByFirstName(String firstName);

}

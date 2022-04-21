package com.api.Visiteur.repository;

import com.api.Visiteur.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Long> {
}

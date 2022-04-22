package com.api.Visiteur.repository;

import com.api.Visiteur.entities.Linkacces;
import com.api.Visiteur.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Linkacces> findAllByAccess(String access);

}

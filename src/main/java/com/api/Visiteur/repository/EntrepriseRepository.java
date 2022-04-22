package com.api.Visiteur.repository;


import com.api.Visiteur.entities.Entreprise;
import com.api.Visiteur.entities.User2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Long> {
  //  List<Entreprise>  findByIfuD( String ifu);
  Optional<Entreprise>  findByIfu( String ifu);


    //List<Entreprise> findEntrepriseById(Long id);
}

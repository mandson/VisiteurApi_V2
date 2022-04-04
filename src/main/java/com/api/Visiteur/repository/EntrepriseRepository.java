package com.api.Visiteur.repository;


import com.api.Visiteur.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Long> {

 //List<Entreprise> findEntrepriseById(Long id);
}

package com.api.Visiteur.repository;


import com.api.Visiteur.dto.VisiteurDTO;
import com.api.Visiteur.entities.User2;
import com.api.Visiteur.entities.Visiteur;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
    List<Visiteur> findVisiteurByIdPersonnel(Long idPersonnel);


  //  List<Visiteur> findVisiteurByIdEntreprise(Long idEntreprise);
   // List<Visiteur> findVisiteurByIdEntrepriseAndEtat(Long idEntreprise,Boolean etat);

}

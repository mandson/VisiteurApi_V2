package com.api.Visiteur.repository;


import com.api.Visiteur.entities.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {


}

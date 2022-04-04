package com.api.Visiteur.repository;


import com.api.Visiteur.entities.VisiteCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VisiteCategorieRepository extends JpaRepository<VisiteCategorie,Long> {
}

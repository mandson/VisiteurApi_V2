package com.api.Visiteur.repository;


import com.api.Visiteur.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
}

package com.api.Visiteur.repository;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.entities.Departement;
import com.api.Visiteur.entities.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement,Long> {
    List<Departement> findDepartementByIdEntreprisef(Long idEntreprisef);

}

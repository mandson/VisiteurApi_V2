package com.api.Visiteur.services;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.EntrepriseDTO;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    DepartementDTO enregisterDepartement(DepartementDTO departementDTO);
    Optional<DepartementDTO> findById(Long id);
    void  suprimer(Long id);
    void  modifier(Long id);
    List<DepartementDTO> listDepartement();

}

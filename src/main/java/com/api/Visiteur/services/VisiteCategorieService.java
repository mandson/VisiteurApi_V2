package com.api.Visiteur.services;

import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.dto.VisiteCategorieDTO;

import java.util.List;
import java.util.Optional;

public interface VisiteCategorieService {

    VisiteCategorieDTO enregisterCategorieVisite(VisiteCategorieDTO visiteCategorieDTO);
    Optional<VisiteCategorieDTO> findById(Long id);
    void  suprimer(Long id);
    void  modifier(Long id);
    List<VisiteCategorieDTO> listCategorieVisite();
}

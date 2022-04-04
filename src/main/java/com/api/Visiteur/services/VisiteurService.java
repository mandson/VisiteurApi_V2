package com.api.Visiteur.services;

import com.api.Visiteur.dto.VisiteurDTO;

import java.util.List;
import java.util.Optional;

public interface VisiteurService {

    VisiteurDTO enregisterVisiteur(VisiteurDTO visiteurDTO);
    Optional<VisiteurDTO> findById(Long id);
    void  suprimer(Long id);
    void  modifier(Long id);
    List<VisiteurDTO> listVisiteur();
}

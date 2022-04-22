package com.api.Visiteur.services;

import com.api.Visiteur.dto.User2Dto;
import com.api.Visiteur.dto.VisiteurDTO;
import com.api.Visiteur.entities.Visiteur;

import java.util.List;
import java.util.Optional;

public interface VisiteurService {

    VisiteurDTO enregisterVisiteur(VisiteurDTO visiteurDTO);
    Optional<VisiteurDTO> findById(Long id);
    void  suprimer(Long id);
    void  modifier(Long id);
    List<VisiteurDTO> listVisiteur();
 //   List<VisiteurDTO> listAllVisite();
   List<VisiteurDTO> findAllbyEtatVisite(Boolean etatVisite);
    List<VisiteurDTO> listVisiteurByIdPersonnelAndEtat(Long idPersonnel,Boolean etatVisite);
    List<VisiteurDTO> listVisiteurByIdPersonnel(Long idPersonnel);


}

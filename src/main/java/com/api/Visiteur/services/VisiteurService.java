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
 //   List<VisiteurDTO> listAllVisite();
   List<VisiteurDTO> findAllbyEtatVisite(Boolean etatVisite);
    List<VisiteurDTO> listVisiteurByIdPersonnelAndEtat(Long idPersonnel,Boolean etatVisite);
    List<VisiteurDTO> listVisiteurByIdPersonnel(Long idPersonnel);
    List<VisiteurDTO> listVisiteurByIdEntreprise(Long idEntreprise);
    List<VisiteurDTO> listVisiteurByIdEntrepriseAndEtat(Long idEntreprise,Boolean etat);
    List<VisiteurDTO> listVisiteurByCodeVisite(String codeVisite);
    //List<VisiteurDTO> listVisiteurByIdEntreprise(Long idEntreprise);

    Long listVisiteurTotalVisiteur(Long idEntreprise);

}

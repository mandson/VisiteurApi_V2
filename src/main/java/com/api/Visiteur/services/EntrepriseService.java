package com.api.Visiteur.services;


import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.dto.User2Dto;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {


     EntrepriseDTO enregisterEntreprise(EntrepriseDTO entrepriseDTO);
     Optional<EntrepriseDTO> findById(Long id);
     void  suprimer(Long id);
     void  modifier(Long id);
     List<EntrepriseDTO> listEntreprise();
     EntrepriseDTO findUserByIfu (String ifu);

}

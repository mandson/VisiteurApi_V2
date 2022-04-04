package com.api.Visiteur.services;

import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.dto.PersonnelDTO;

import java.util.List;
import java.util.Optional;

public interface PersonnelService {

    PersonnelDTO enregisterPersonnel(PersonnelDTO personnelDTO);
    Optional<PersonnelDTO> findById(Long id);
    void  suprimer(Long id);
    void  modifier(Long id);
    List<PersonnelDTO> listPersonnel();
}

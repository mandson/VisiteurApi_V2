package com.api.Visiteur.web.endPoint;


import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.services.EntrepriseService;
import com.api.Visiteur.web.controller.EntrepriseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EntrepriseRestApi implements EntrepriseController {

    @Autowired
    public EntrepriseService entrepriseService;

    public EntrepriseRestApi(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }


    @Override
    public List<EntrepriseDTO> findAll() {
        return entrepriseService.listEntreprise();
    }

    @Override
    public EntrepriseDTO save(EntrepriseDTO dto) {
        return entrepriseService.enregisterEntreprise(dto);

    }

    @Override
    public void delete(Long id) {
        entrepriseService.suprimer(id);
    }

    @Override
    public Optional<EntrepriseDTO> findById(Long id) {
        return entrepriseService.findById(id);
    }

    @Override
    public Optional<EntrepriseDTO> findByIfu(String ifu) {
        return Optional.ofNullable(entrepriseService.findUserByIfu(ifu));
    }


    @Override
    public void modifier(Long id) {
entrepriseService.modifier(id);
    }


}

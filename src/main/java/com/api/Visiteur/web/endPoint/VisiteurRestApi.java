package com.api.Visiteur.web.endPoint;


import com.api.Visiteur.dto.VisiteurDTO;
import com.api.Visiteur.services.VisiteurService;
import com.api.Visiteur.web.controller.VisiteurController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VisiteurRestApi  implements VisiteurController {

@Autowired
    VisiteurService visiteurService;

    public VisiteurRestApi(VisiteurService visiteurService) {
        this.visiteurService = visiteurService;
    }


    @Override
    public List<VisiteurDTO> listVisiteurs() {
        return visiteurService.listVisiteur();
    }

    @Override
    public VisiteurDTO save(VisiteurDTO dto) {
        return visiteurService.enregisterVisiteur(dto);
    }

    @Override
    public void delete(Long id) {
visiteurService.modifier(id);
    }

    @Override
    public Optional<VisiteurDTO> findById(Long id) {
        return visiteurService.findById(id);
    }

    @Override
    public void modifier(Long id) {

    }
}

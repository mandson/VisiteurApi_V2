package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.entities.Personnel;
import com.api.Visiteur.services.PersonnelService;
import com.api.Visiteur.web.controller.PersonnelController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonnelRestApi implements PersonnelController {
    @Autowired
    PersonnelService personnelService;

    public PersonnelRestApi(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }


    @Override
    public List<PersonnelDTO> listPersonnel() {
        return personnelService.listPersonnel();
    }

    @Override
    public PersonnelDTO save(PersonnelDTO dto) {
        return personnelService.enregisterPersonnel(dto);
    }

    @Override
    public void delete(Long id) {
        personnelService.suprimer(id);
    }

    @Override
    public Optional<PersonnelDTO> findById(Long id) {
        return personnelService.findById(id);
    }

    @Override
    public void modifier(Long id) {


    }
}

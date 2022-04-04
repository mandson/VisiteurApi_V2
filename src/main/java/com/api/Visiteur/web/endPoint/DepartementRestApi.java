package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.services.DepartementService;
import com.api.Visiteur.web.controller.DepartementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartementRestApi  implements DepartementController {
    @Autowired
    DepartementService departementService;

    public DepartementRestApi(DepartementService departementService) {
        this.departementService = departementService;
    }

    @Override
    public List<DepartementDTO> findAll() {
        return departementService.listDepartement();
    }

    @Override
    public DepartementDTO save(DepartementDTO dto) {
        return departementService.enregisterDepartement(dto);
    }

    @Override
    public void delete(Long id) {
    departementService.suprimer(id);
    }

    @Override
    public Optional<DepartementDTO> findById(Long id) {
        return departementService.findById(id);
    }

    @Override
    public void modifier(Long id) {

    }
}

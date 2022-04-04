package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.VisiteCategorieDTO;
import com.api.Visiteur.services.VisiteCategorieService;
import com.api.Visiteur.web.controller.VisiteCategorieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategorieVisiteRestApi  implements VisiteCategorieController {

@Autowired
    VisiteCategorieService visiteCategorieService;

    public CategorieVisiteRestApi(VisiteCategorieService visiteCategorieService) {
        this.visiteCategorieService = visiteCategorieService;
    }

    @Override
    public List<VisiteCategorieDTO> listCategorieVisites() {
        return visiteCategorieService.listCategorieVisite();
    }

    @Override
    public VisiteCategorieDTO save(VisiteCategorieDTO dto) {
        return visiteCategorieService.enregisterCategorieVisite(dto);
    }

    @Override
    public void delete(Long id) {
visiteCategorieService.suprimer(id);
    }

    @Override
    public Optional<VisiteCategorieDTO> findById(Long id) {
        return visiteCategorieService.findById(id);
    }

    @Override
    public void modifier(Long id) {

    }
}

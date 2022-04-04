package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.dto.VisiteCategorieDTO;
import com.api.Visiteur.repository.VisiteCategorieRepository;
import com.api.Visiteur.services.VisiteCategorieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VisiteCategorieServiceImpl  implements VisiteCategorieService {

    @Autowired
    VisiteCategorieRepository visiteCategorieRepository;

    public VisiteCategorieServiceImpl(VisiteCategorieRepository visiteCategorieRepository) {
        this.visiteCategorieRepository = visiteCategorieRepository;
    }

    @Override
    public VisiteCategorieDTO enregisterCategorieVisite(VisiteCategorieDTO visiteCategorieDTO) {
        return  VisiteCategorieDTO.convertVisiteurcategorieTovisiteurCategorieDto(
                visiteCategorieRepository.save(VisiteCategorieDTO.convertVisiteurcategorieDTOTovisiteurCategorie(visiteCategorieDTO))
        );
    }

    @Override
    public Optional<VisiteCategorieDTO> findById(Long id) {

        return  visiteCategorieRepository.findById(id).map(VisiteCategorieDTO::convertVisiteurcategorieTovisiteurCategorieDto);
    }

    @Override
    public void suprimer(Long id) {
      visiteCategorieRepository.deleteById(id);
    }

    @Override
    public void modifier(Long id) {

    }

    @Override
    public List<VisiteCategorieDTO> listCategorieVisite() {
        return visiteCategorieRepository.findAll().stream().map(VisiteCategorieDTO::convertVisiteurcategorieTovisiteurCategorieDto).collect(Collectors.toList());
    }
}

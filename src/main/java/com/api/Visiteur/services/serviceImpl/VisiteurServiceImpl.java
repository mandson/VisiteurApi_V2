package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.VisiteurDTO;
import com.api.Visiteur.repository.VisiteurRepository;
import com.api.Visiteur.services.VisiteurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class VisiteurServiceImpl  implements VisiteurService {

    @Autowired
    VisiteurRepository visiteurRepository;


    public VisiteurServiceImpl(VisiteurRepository visiteurRepository) {
        this.visiteurRepository = visiteurRepository;
    }

    @Override
    public VisiteurDTO enregisterVisiteur(VisiteurDTO visiteurDTO) {
        return VisiteurDTO.converteVisiteurToVisiteurDTO(
                visiteurRepository.save(VisiteurDTO.converteVisiteurDTOToVisiteur(visiteurDTO))
        );
    }

    @Override
    public Optional<VisiteurDTO> findById(Long id) {
        return visiteurRepository.findById(id).map(VisiteurDTO::converteVisiteurToVisiteurDTO);
    }

    @Override
    public void suprimer(Long id) {
   visiteurRepository.deleteById(id);
    }

    @Override
    public void modifier(Long id) {

    }

    @Override
    public List<VisiteurDTO> listVisiteur() {
        return visiteurRepository.findAll().stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getEtatVisite() ==true)
                .collect(Collectors.toList());
    }
}

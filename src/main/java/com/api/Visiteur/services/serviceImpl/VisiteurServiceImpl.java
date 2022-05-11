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

                .collect(Collectors.toList());
    }

    @Override
    public List<VisiteurDTO> findAllbyEtatVisite(Boolean etatVisite) {
        return visiteurRepository.findAll().stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getEtatVisite().equals(etatVisite) )
                .collect(Collectors.toList());    }

    @Override
    public List<VisiteurDTO> listVisiteurByIdPersonnelAndEtat(Long idPersonnel,Boolean etatVisite) {
        return visiteurRepository.findVisiteurByIdPersonnel(idPersonnel).stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getEtatVisite().equals(etatVisite) )
                .collect(Collectors.toList());    }

    @Override
    public List<VisiteurDTO> listVisiteurByIdPersonnel(Long idPersonnel) {
        return visiteurRepository.findVisiteurByIdPersonnel(idPersonnel).stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getEtatVisite().equals(true) )
                .collect(Collectors.toList());       }

    @Override
    public List<VisiteurDTO> listVisiteurByIdEntreprise(Long idEntreprise) {
        return visiteurRepository.findAll().stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getUser2().getIdEntreprisef().equals(idEntreprise) )
                .collect(Collectors.toList());
    }


    @Override
    public List<VisiteurDTO> listVisiteurByIdEntrepriseAndEtat(Long idEntreprise, Boolean etat) {
        return visiteurRepository.findAll().stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getUser2().getIdEntreprisef().equals(idEntreprise) )
                .filter(visiteurDTO -> visiteurDTO.getEtatVisite().equals(etat))
                .collect(Collectors.toList());
    }

    @Override
    public List<VisiteurDTO> listVisiteurByCodeVisite(String codeVisite) {
        return visiteurRepository.findAll().stream().map(VisiteurDTO::converteVisiteurToVisiteurDTO)
                .filter(visiteurDTO -> visiteurDTO.getCodeVisite().equals(codeVisite) )
                .collect(Collectors.toList());
    }
}

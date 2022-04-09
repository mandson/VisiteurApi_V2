package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.repository.EntrepriseRepository;
import com.api.Visiteur.services.EntrepriseService;
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

public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDTO enregisterEntreprise(EntrepriseDTO dto) {

        return  EntrepriseDTO.converteEntrepriseToEntrepriseDTO(
          entrepriseRepository.save(EntrepriseDTO.convertEntrepriseDTOtoEntreprise(dto))
        );

    }

    @Override
    public Optional<EntrepriseDTO> findById(Long id) {
        return  entrepriseRepository.findById(id).map(EntrepriseDTO::converteEntrepriseToEntrepriseDTO)
                ;
    }


    @Override
    public void suprimer(Long id) {
    //findById(id);
      entrepriseRepository.deleteById(id);

    }

    @Override
    public void modifier(Long id) {

    }

    @Override
    public List<EntrepriseDTO> listEntreprise() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDTO::converteEntrepriseToEntrepriseDTO)
                .collect(Collectors.toList());
    }
}

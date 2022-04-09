package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.repository.PersonnelRepository;
import com.api.Visiteur.services.PersonnelService;
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
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    PersonnelRepository personnelRepository;

    public PersonnelServiceImpl(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }


    @Override
    public PersonnelDTO enregisterPersonnel(PersonnelDTO personnelDTO) {
        return  PersonnelDTO.convertePersonnelToPersonnelDTO(
                personnelRepository.save(PersonnelDTO.convertPersonnelDTOtoPersonnel(personnelDTO))
        );    }

    @Override
    public Optional<PersonnelDTO> findById(Long id) {
        return personnelRepository.findById(id).map(PersonnelDTO::convertePersonnelToPersonnelDTO);
    }


    @Override
    public void suprimer(Long id) {
     personnelRepository.deleteById(id);
    }

    @Override
    public void modifier(Long id) {


    }

    @Override
    public List<PersonnelDTO> listPersonnel() {
        return personnelRepository.findAll().stream()
                .map(PersonnelDTO::convertePersonnelToPersonnelDTO)
                .collect(Collectors.toList());
    }
}

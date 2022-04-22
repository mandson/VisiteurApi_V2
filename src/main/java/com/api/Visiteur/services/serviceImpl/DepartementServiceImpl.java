package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.DepartementDTO;
import com.api.Visiteur.dto.EntrepriseDTO;
import com.api.Visiteur.repository.DepartementRepository;
import com.api.Visiteur.services.DepartementService;
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
public class DepartementServiceImpl  implements DepartementService {

    @Autowired
    DepartementRepository departementRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public DepartementDTO enregisterDepartement(DepartementDTO departementDTO) {
        return  DepartementDTO.converteDepartementToDepartementDTO(
                departementRepository.save(DepartementDTO.convertDepartementDTOtoDepartement(departementDTO))
        );    }

    @Override
    public Optional<DepartementDTO> findById(Long id) {
        return  departementRepository.findById(id).map(DepartementDTO::converteDepartementToDepartementDTO)
                ;    }

    @Override
    public void suprimer(Long id) {
     departementRepository.deleteById(id);
    }

    @Override
    public void modifier(Long id) {

    }

    @Override
    public List<DepartementDTO> listDepartement() {
        return departementRepository.findAll().stream()
                .map(DepartementDTO::converteDepartementToDepartementDTO).collect(Collectors.toList());
    }

    @Override
    public List<DepartementDTO> listDepartementByIdEntreprise(Long idEntreprise) {
        return departementRepository.findDepartementByIdEntreprisef(idEntreprise).stream()
                .filter(departement ->idEntreprise.equals(idEntreprise) )
                .map(DepartementDTO::converteDepartementToDepartementDTO).collect(Collectors.toList());

    }

}

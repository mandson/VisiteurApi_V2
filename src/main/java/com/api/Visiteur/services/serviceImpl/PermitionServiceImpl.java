package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.PermitionDto;
import com.api.Visiteur.repository.PermitionRepository;
import com.api.Visiteur.services.PermitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class PermitionServiceImpl implements PermitionService {

    @Autowired
    PermitionRepository permitionRepository;

    public PermitionServiceImpl(PermitionRepository permitionRepository) {
        this.permitionRepository = permitionRepository;
    }

    @Override
    public List<PermitionDto> listPermition() {
        return permitionRepository.findAll().stream()
                .map(PermitionDto::fromEntity)
                .collect( Collectors.toList())
                ;
    }

    @Override
    public PermitionDto save(PermitionDto dto) {

        return  PermitionDto.fromEntity(
                permitionRepository.save(PermitionDto.toEntity(dto))
        );       }

    @Override
    public PermitionDto findById(Long id) {
        if (id == null){
            return  null;
        }


        return permitionRepository.findById(id)
                .map(PermitionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition avec l'ID = "+id+ "n'a ete trouver dans la base de BDD")
                );          }

    @Override
    public void delete(Long id) {

        permitionRepository.deleteById( id );
    }

    @Override
    public void update(Long id) {

    }
}

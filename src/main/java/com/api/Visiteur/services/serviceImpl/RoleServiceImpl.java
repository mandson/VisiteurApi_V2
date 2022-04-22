package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.RoleDto;
import com.api.Visiteur.repository.RoleRepository;
import com.api.Visiteur.services.RoleService;
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
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<RoleDto> listRole() {
        return roleRepository.findAll().stream()
                .map( RoleDto::fromEntity)
                .collect( Collectors.toList())
                ;
    }

    @Override
    public RoleDto save(RoleDto dto) {

        return  RoleDto.fromEntity(
                roleRepository.save(RoleDto.toEntity(dto))
        );
    }

    @Override
    public RoleDto findById(Long id) {
        if (id == null){
            return  null;
        }


        return roleRepository.findById(id)
                .map(RoleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition avec l'ID = "+id+ "n'a ete trouver dans la base de BDD")
                );
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById( id );
    }

    @Override
    public void update(Long id) {

    }
}

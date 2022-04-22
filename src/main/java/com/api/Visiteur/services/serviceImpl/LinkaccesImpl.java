package com.api.Visiteur.services.serviceImpl;

import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.repository.LinkaccesRepository;
import com.api.Visiteur.services.Linkacces;
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
public class LinkaccesImpl implements Linkacces {

    @Autowired
    LinkaccesRepository linkaccesRepository;

    @Override
    public List<LinkaccesDto> listAccesPermitionRole() {
        return linkaccesRepository.findAll().stream()
                .map( LinkaccesDto::fromEntity)
                .collect( Collectors.toList())
                ;     }

    @Override
    public LinkaccesDto save(LinkaccesDto dto) {
        return  LinkaccesDto.fromEntity(
                linkaccesRepository.save(LinkaccesDto.toEntity(dto))
        );       }

    @Override
    public LinkaccesDto findById(Long id) {
        if (id == null){
            return  null;
        }


        return linkaccesRepository.findById(id)
                .map(LinkaccesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition ou role avec l'ID = "+id+ "n'a ete trouver dans la base de BDD")
                );         }

    @Override
    public void delete(Long id) {
        linkaccesRepository.deleteById( id );
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<LinkaccesDto> findAllpermissionsByRole(Long idRole) {
        return linkaccesRepository.findAllByIdRole(idRole).stream()

                .map(LinkaccesDto::fromEntity)


                .collect(Collectors.toList())

                ;
    }

    @Override
    public List<LinkaccesDto> findListeByIdRoleAndIdPermition(Long idRole, Long idPermition) {
        return linkaccesRepository.findAllByIdRole(idRole).stream()

                .map(LinkaccesDto::fromEntity)

                .filter( linkaccesDto -> idPermition.equals( idPermition ) )
                .limit( 1 )
                .collect( Collectors.toList());

    }

    @Override
    public LinkaccesDto findOneByIdRoleAndIdPermition(Long idRole, Long idPermition) {

        return linkaccesRepository.findById(idRole)
                .filter( linkacces -> idPermition.equals( idPermition ) )
                .map(LinkaccesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(

                        "Aucune permition ou role avec l'ID = "+idRole+ "n'a ete trouver dans la base de BDD")
                );            }
}


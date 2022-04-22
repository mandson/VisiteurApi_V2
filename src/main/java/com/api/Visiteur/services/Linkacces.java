package com.api.Visiteur.services;

import com.api.Visiteur.dto.LinkaccesDto;

import java.util.List;

public interface Linkacces {
    List<LinkaccesDto> listAccesPermitionRole();
    LinkaccesDto save(LinkaccesDto dto);
    LinkaccesDto findById(Long id);
    // RoleDto findByEmailAndPassword(String email,String password);

    void delete(Long id);
    void update(  Long id);
    List<LinkaccesDto> findAllpermissionsByRole(Long idRole);
    List<LinkaccesDto> findListeByIdRoleAndIdPermition(Long idRole, Long idPermition);
    LinkaccesDto findOneByIdRoleAndIdPermition(Long idRole, Long idPermition);


}

package com.api.Visiteur.web.endPoint;

import com.api.Visiteur.dto.LinkaccesDto;
import com.api.Visiteur.services.Linkacces;
import com.api.Visiteur.web.controller.LinkaccesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LinkaccesController implements LinkaccesApi {

    @Autowired
    Linkacces linkaccesService;
    @Override
    public List<LinkaccesDto> findAll() {
        return linkaccesService.listAccesPermitionRole();
    }

    @Override
    public LinkaccesDto save(LinkaccesDto dto) {

        return linkaccesService.save( dto );
    }

    @Override
    public LinkaccesDto findById(Long id) {
        return linkaccesService.findById( id )
                ;
    }

    @Override
    public List<LinkaccesDto> listePermitionByRole(Long idrole) {
        return linkaccesService.findAllpermissionsByRole( idrole );
    }

    @Override
    public boolean findListeparIdRoleAndIdPermition(Long idrole, Long idpermition) {
        if (
                linkaccesService.findListeByIdRoleAndIdPermition( idrole,idpermition ).isEmpty()

        ){
            return false;}
        else {
            return true;}
    }

    @Override
    public LinkaccesDto findOneByIdRoleAndIdPermition(Long idrole, Long idpermition) {
        return linkaccesService.findOneByIdRoleAndIdPermition( idrole,idpermition );
    }

    @Override
    public void modifier(Long id) {

    }

    @Override
    public void delete(Long id) {
        linkaccesService.delete( id );
    }
}

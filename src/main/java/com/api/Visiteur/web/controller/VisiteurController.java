package com.api.Visiteur.web.controller;

import com.api.Visiteur.dto.PersonnelDTO;
import com.api.Visiteur.dto.VisiteurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.api.Visiteur.utils.constants.APP_ROOT;

public interface VisiteurController {
    @GetMapping(value =APP_ROOT+"/visiteur/liste",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> listVisiteurs();
    @GetMapping(value =APP_ROOT+"/visiteur/liste/{etatVisite}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> findAllbyEtatVisite( @PathVariable("etatVisite") Boolean etatVisite);

    @GetMapping(value =APP_ROOT+"/visiteur/liste/codevisite/{codevisite}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> findAllVisiteByCodeVisite( @PathVariable("codevisite") String codevisite);

    @GetMapping(value =APP_ROOT+"/visiteur/liste/idpersonnel/{idpersonnel}/visiteEtat/{etatVisite}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> findAllbyidPersonnelandetat( @PathVariable Long idpersonnel,@PathVariable Boolean etatVisite);


    @GetMapping(value =APP_ROOT+"/visiteur/liste/identreprise/{identreprise}/visiteEtat/{etatVisite}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> findAllbyIdentrepriseAndEtat( @PathVariable Long identreprise,@PathVariable Boolean etatVisite);


    @GetMapping(value =APP_ROOT+"/visiteur/liste/idpersonnel/{idpersonnel}",produces = MediaType.APPLICATION_JSON_VALUE )
    List<VisiteurDTO> findAllbyidPersonnel( @PathVariable Long idpersonnel);

    @PostMapping(value =APP_ROOT+"/visiteur/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VisiteurDTO save(@RequestBody VisiteurDTO dto);


    @DeleteMapping(value =APP_ROOT+"/visiteur/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/visiteur/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    Optional<VisiteurDTO> findById(@PathVariable("id") Long id);


    @GetMapping(value =APP_ROOT+"/visiteur/edite/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    void modifier(@PathVariable("id")  Long id);

}

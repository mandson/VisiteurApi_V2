package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Personnel;
import com.api.Visiteur.entities.User2;
import com.api.Visiteur.entities.VisiteCategorie;
import com.api.Visiteur.entities.Visiteur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Builder
@Data
@Transactional
public class VisiteurDTO {

    private Long id;
    private String nom;
    private String prenom;
    private Integer contact;
    private String address;
    private String motifVisite;

    private String photo;
    private String numeroCnib;

    private LocalDateTime dateVisite;

    private String entreprise;
    private Date heureEntrer;
    private Time heurSortie;
    private User2 user2;
    private VisiteCategorie visiteCategorie;
    private Long idPersonnel;
    private Boolean etatVisite;

    public static VisiteurDTO converteVisiteurToVisiteurDTO( Visiteur visiteur  ){
        if (visiteur==null){
            return null;
        }

        return VisiteurDTO.builder()
                .id(visiteur.getId())
                .nom(visiteur.getNom())
                .prenom(visiteur.getPrenom())
                .contact(visiteur.getContact())
                .address(visiteur.getAddress())
                .photo(visiteur.getPhoto())
                .dateVisite(visiteur.getDateVisite())
                .entreprise(visiteur.getEntreprise())
                .heureEntrer(visiteur.getHeureEntrer())
                .heurSortie(visiteur.getHeurSortie())
                .user2(visiteur.getUser2())
                .visiteCategorie(visiteur.getVisiteCategorie())
                .idPersonnel(visiteur.getIdPersonnel())
                .numeroCnib(visiteur.getNumeroCnib())
                .etatVisite(visiteur.getEtatVisite())
                .motifVisite(visiteur.getMotifVisite())
                .build();
    }

    public  static  Visiteur converteVisiteurDTOToVisiteur(VisiteurDTO visiteurDTO){
        if (visiteurDTO==null){
            return null;
        }

        Visiteur visiteur = new Visiteur();
        visiteur.setId(visiteurDTO.getId());
        visiteur.setNom(visiteurDTO.getNom());
        visiteur.setPrenom(visiteurDTO.getPrenom());
        visiteur.setContact(visiteurDTO.getContact());
        visiteur.setAddress(visiteurDTO.getAddress());
        visiteur.setPhoto(visiteurDTO.getPhoto());
        visiteur.setDateVisite(LocalDateTime.now());
        visiteur.setEntreprise(visiteurDTO.getEntreprise());
        visiteur.setHeureEntrer(visiteurDTO.getHeureEntrer());
        visiteur.setHeurSortie(visiteurDTO.getHeurSortie());
        visiteur.setNumeroCnib(visiteurDTO.getNumeroCnib());
        visiteur.setEtatVisite(visiteurDTO.getEtatVisite());
        visiteur.setIdPersonnel(visiteurDTO.getIdPersonnel());
        visiteur.setMotifVisite(visiteurDTO.getMotifVisite());
        // visiteur.setPersonnel(visiteurDTO.getPersonnel());
         PersonnelDTO MypersonnelsDTO;
       visiteur.setUser2(User2Dto
               .toEntity(User2Dto
                       .builder()
                       .id(visiteurDTO.getIdPersonnel())
                       .build()));

      //  visiteur.setPersonnel(1);
        visiteur.setVisiteCategorie(visiteurDTO.getVisiteCategorie());

        return visiteur;
    }


}



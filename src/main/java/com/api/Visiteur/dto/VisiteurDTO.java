package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Personnel;
import com.api.Visiteur.entities.VisiteCategorie;
import com.api.Visiteur.entities.Visiteur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;
@Builder
@Data
public class VisiteurDTO {

    private Long id;
    private String nom;
    private String prenom;
    private Integer contact;
    private String address;
    private String photo;
    private Date dateVisite;
    private String entreprise;
    private String heureEntrer;
    private String heurSortie;
    private Personnel personnel;
    private VisiteCategorie visiteCategorie;

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
                .personnel(visiteur.getPersonnel())
                .visiteCategorie(visiteur.getVisiteCategorie())
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
        visiteur.setDateVisite(visiteurDTO.dateVisite);
        visiteur.setEntreprise(visiteur.getEntreprise());
        visiteur.setHeureEntrer(visiteur.getHeureEntrer());
        visiteur.setHeurSortie(visiteur.getHeurSortie());
        visiteur.setPersonnel(visiteur.getPersonnel());
        visiteur.setVisiteCategorie(visiteur.getVisiteCategorie());

        return visiteur;
    }
}

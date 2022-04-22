package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Entreprise;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Builder
@Data
public class EntrepriseDTO {
    private  Long id;
    private  String nomEntreprise;
    private  String logo;
    private  String sigle;
    private  String boitePostal;

    private  String pays;
    private  String ville;
    private  String ifu;
    private Date cratedAt;

    public static EntrepriseDTO converteEntrepriseToEntrepriseDTO( Entreprise entreprise  ){
        if (entreprise==null){
            return null;
        }

        return EntrepriseDTO.builder()
                .id(entreprise.getId())
                .nomEntreprise(entreprise.getNomEntreprise())
                .sigle(entreprise.getSigle())
                .logo(entreprise.getLogo())
                .boitePostal(entreprise.getBoitePostal())
                .pays(entreprise.getPays())
                .ville(entreprise.getVille())
                .ifu(entreprise.getIfu())
                .cratedAt(entreprise.getCratedAt())
                .build();
    }
    public static EntrepriseDTO fromEntity(Entreprise entreprise){
        if (entreprise == null) {
            return null;
        }

        return EntrepriseDTO.builder()
                .id(entreprise.getId())
                .nomEntreprise(entreprise.getNomEntreprise())
                .sigle(entreprise.getSigle())
                .logo(entreprise.getLogo())
                .boitePostal(entreprise.getBoitePostal())
                .pays(entreprise.getPays())
                .ville(entreprise.getVille())
                .ifu(entreprise.getIfu())
                .cratedAt(entreprise.getCratedAt())
                .build();
    }

    public static Entreprise convertEntrepriseDTOtoEntreprise(EntrepriseDTO entrepriseDTO){
         Entreprise entreprise = new Entreprise() ;
         entreprise.setNomEntreprise(entrepriseDTO.getNomEntreprise());

         entreprise.setLogo(entrepriseDTO.getLogo());
         entreprise.setBoitePostal(entrepriseDTO.getBoitePostal());
         entreprise.setSigle(entrepriseDTO.getSigle());
         entreprise.setId(entrepriseDTO.getId());
         entreprise.setPays(entrepriseDTO.getPays());
         entreprise.setVille(entrepriseDTO.getVille());
         entreprise.setIfu(entrepriseDTO.getIfu());

         return entreprise;

    }

}

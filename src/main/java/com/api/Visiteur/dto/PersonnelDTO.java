package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Departement;
import com.api.Visiteur.entities.Entreprise;
import com.api.Visiteur.entities.Personnel;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
@Builder
@Data
public class PersonnelDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String contact;
    private String mail;
    private String matricule;
    private String bureau;
    private Departement departementId;
    private Long departId;
    public static PersonnelDTO convertePersonnelToPersonnelDTO( Personnel personnel  ){
        if (personnel==null){
            return null;
        }

        return PersonnelDTO.builder()
                .id(personnel.getId())
                .nom(personnel.getNom())
                .prenom(personnel.getPrenom())
                .contact(personnel.getContact())
                .mail(personnel.getMail())
                .matricule(personnel.getMatricule())
                .bureau(personnel.getBureau())
                .departementId(personnel.getDepartement())
                .departId(personnel.getDepartId())
                .build();
    }
    public static Personnel convertPersonnelDTOtoPersonnel(PersonnelDTO personnelDTO){
        Personnel personnel = new Personnel() ;
        personnel.setId(personnelDTO.getId());
        personnel.setNom(personnelDTO.getNom());
        personnel.setPrenom(personnelDTO.getPrenom());
        personnel.setContact(personnelDTO.getContact());
        personnel.setMail(personnelDTO.getMail());
        personnel.setMatricule(personnelDTO.getMatricule());
        personnel.setBureau(personnelDTO.getBureau());
        personnel.setDepartement(personnelDTO.departementId);
        personnel.setDepartement(DepartementDTO
                .convertDepartementDTOtoDepartement(DepartementDTO
                        .builder()
                        .id(personnelDTO.getDepartId())
                        .build()));

        return personnel;

    }
}

package com.api.Visiteur.dto;

import com.api.Visiteur.entities.Departement;
import com.api.Visiteur.entities.Entreprise;
import com.api.Visiteur.repository.EntrepriseRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.ManyToOne;
import java.util.List;

@Builder
@Data
public class DepartementDTO {
    private  Long id;
    private  String nomDepartement;
    private  String descriptionDepartement;
    private Entreprise entreprise;
    private Long idEntreprisef;

    private Long idEntreprise;
    public static DepartementDTO converteDepartementToDepartementDTO( Departement departement  ){
        if (departement==null){
            return null;
        }

        return DepartementDTO.builder()
                .id(departement.getId())
                .nomDepartement(departement.getNomDepartement())
                .descriptionDepartement(departement.getDescriptionDepartement())
                .entreprise(departement.getEntreprise())
                .idEntreprise(departement.getEntreprise().getId())
                .idEntreprisef(departement.getIdEntreprisef())
                .build();
    }

    public static Departement convertDepartementDTOtoDepartement(DepartementDTO departementDTO){
        Departement departement = new Departement() ;
        departement.setId(departementDTO.getId());
        departement.setNomDepartement(departementDTO.getNomDepartement());
        departement.setDescriptionDepartement(departementDTO.getDescriptionDepartement());
        departement.setIdEntreprisef(departementDTO.getIdEntreprisef());

        departement.setEntreprise(EntrepriseDTO.convertEntrepriseDTOtoEntreprise(
                EntrepriseDTO.builder()
                        .id(departementDTO.getIdEntreprise())
                        .build()
        ));
        return departement;

    }

}

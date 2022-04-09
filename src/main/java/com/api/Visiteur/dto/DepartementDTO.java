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
    private Entreprise entrepriseId;

    public static DepartementDTO converteDepartementToDepartementDTO( Departement departement  ){
        if (departement==null){
            return null;
        }

        return DepartementDTO.builder()
                .id(departement.getId())
                .nomDepartement(departement.getNomDepartement())
                .descriptionDepartement(departement.getDescriptionDepartement())
                .entrepriseId(departement.getEntreprise())
                .build();
    }

    public static Departement convertDepartementDTOtoDepartement(DepartementDTO departementDTO){
        Departement departement = new Departement() ;
        departement.setId(departementDTO.getId());
        departement.setNomDepartement(departementDTO.getNomDepartement());
        departement.setDescriptionDepartement(departementDTO.getDescriptionDepartement());
        departement.setEntreprise(departementDTO.getEntrepriseId());
        return departement;

    }

}

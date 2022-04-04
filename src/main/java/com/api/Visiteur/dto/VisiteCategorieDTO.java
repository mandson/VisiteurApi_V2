package com.api.Visiteur.dto;

import com.api.Visiteur.entities.VisiteCategorie;
import com.api.Visiteur.entities.Visiteur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data @Builder
public class VisiteCategorieDTO {

    private  Long id;
    private String typeVisite;

    public  static  VisiteCategorieDTO convertVisiteurcategorieTovisiteurCategorieDto(VisiteCategorie categorie){

        return  VisiteCategorieDTO.builder()
                .id(categorie.getId())
                .typeVisite(categorie.getTypeVisite())
                .build();
    }
    public static VisiteCategorie convertVisiteurcategorieDTOTovisiteurCategorie(VisiteCategorieDTO categorieDTO){

        VisiteCategorie visiteCategorie = new VisiteCategorie();
        visiteCategorie.setId(categorieDTO.getId());
        visiteCategorie.setTypeVisite(categorieDTO.getTypeVisite());

        return  visiteCategorie;
    }
}

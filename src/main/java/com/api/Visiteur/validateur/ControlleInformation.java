package com.api.Visiteur.validateur;

import com.api.Visiteur.dto.EntrepriseDTO;

import java.util.ArrayList;
import java.util.List;

public class ControlleInformation {

    public  List<String>entreprise(EntrepriseDTO entrepriseDTO){
        List<String>erreurDetecter = new ArrayList<>();
        if (entrepriseDTO.getNomEntreprise() == null || entrepriseDTO.getLogo() == null ){
            erreurDetecter.add("Vous devez absolument renseigner le nom et le logo de lentreprise");
            return erreurDetecter;
        }
        erreurDetecter.add("Auccune erreur detecter");
        return erreurDetecter;
    }
}

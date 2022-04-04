package com.api.Visiteur.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@EqualsAndHashCode
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Entreprise  implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private  String nomEntreprise;
    private  String logo;
    private  String sigle;
    private  String boitePostal;
    @OneToMany(mappedBy = "entreprise")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Departement>departements;
}

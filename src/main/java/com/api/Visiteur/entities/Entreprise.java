package com.api.Visiteur.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Entreprise  implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private  String nomEntreprise;
    private  String pays;
    private  String ville;
    @Column(unique = true,nullable = true)
    private  String ifu;
    private  String logo;
    private  String sigle;
    private  String boitePostal;
    private Date cratedAt= new Date(System.currentTimeMillis());
    @OneToMany(mappedBy = "entreprise")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Departement>departements;
}

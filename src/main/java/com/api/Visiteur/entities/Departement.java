package com.api.Visiteur.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Departement  implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private  String nomDepartement;
    private  String descriptionDepartement;
    private Long idEntreprisef;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Entreprise entreprise;

    @OneToMany(mappedBy = "departement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Personnel>personnels;


    @OneToMany(mappedBy = "departement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<User2>user2;
}

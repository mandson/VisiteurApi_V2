package com.api.Visiteur.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Personnel  implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String contact;
    private String mail;
    @Column(unique=true)
    private String matricule;
    private String bureau;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Departement departement;

    @OneToMany(mappedBy ="personnel" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Visiteur>visiteurs;

}

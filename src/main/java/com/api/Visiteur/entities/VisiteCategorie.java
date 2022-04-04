package com.api.Visiteur.entities;

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
public class VisiteCategorie  implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private String typeVisite;
    
    @OneToMany(mappedBy ="visiteCategorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Visiteur>visiteurs;
}

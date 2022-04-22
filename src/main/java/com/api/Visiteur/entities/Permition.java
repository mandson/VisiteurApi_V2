package com.api.Visiteur.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Permition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codePermition;
    private String description;

    @OneToMany(mappedBy ="permitions" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Linkacces> linkacces;
}



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
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nameRole;
    private String codeRole;
    private String descriptionRole;
    private String userCrateName;

    @OneToMany(mappedBy ="roles" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Linkacces> linkacces;

    @OneToMany(mappedBy ="roles" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<User2> users;


}

package com.api.Visiteur.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Linkacces implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role roles;

    @ManyToOne
    @JoinColumn(name = "permition_id")

    private Permition permitions;

    private String userCrateName;
    private Integer idRole;
    private Long idPermition;


}

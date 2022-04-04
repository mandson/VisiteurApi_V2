package com.api.Visiteur.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Visiteur  implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Integer contact;
    private String address;
    private String photo;
    private Date dateVisite;
    private String entreprise;
    private String heureEntrer;
    private String heurSortie;
    @ManyToOne
    private  Personnel personnel;
    @ManyToOne
    private VisiteCategorie visiteCategorie;

}

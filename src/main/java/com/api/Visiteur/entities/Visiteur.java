package com.api.Visiteur.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private String numeroCnib;
    private String motifVisite;
    private Boolean visitePlanifier;
    @Column(unique = true)
    private String codeVisite;
    private LocalDateTime  dateVisite;
    private String entreprise;
    private Date heureEntrer= new Date(System.currentTimeMillis());

    private Time heurSortie= new Time(System.currentTimeMillis());
    private Long idPersonnel;
    private Boolean etatVisite = true;
    private String email;


    @ManyToOne
    private  User2 user2;
    @ManyToOne
    private VisiteCategorie visiteCategorie;

}

package com.api.Visiteur.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User2  implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String userId;
        private String firstName;
        private String lastName;
        @Column(unique = true,length = 40)
        private String matricule;
        private Long contact;
        private String bureau;
        private String password;
        @Column(unique = true,length = 40)
        private String email;
        private String profilImage;
        private Date lastLogingDate;
        private  Date cratedAt= new Date(System.currentTimeMillis());
        private Integer idRole;
        private Boolean isActive;
        private Boolean isNotLocked;
        private Long idDepartement;
        private Long idEntreprisef;
        @ManyToOne
        private Role roles;


        @OneToMany(mappedBy ="user2" )
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Collection<Visiteur> visiteurs;

        @ManyToOne
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Departement departement;

        @OneToOne
        private Photovisiteur photovisiteur;

}

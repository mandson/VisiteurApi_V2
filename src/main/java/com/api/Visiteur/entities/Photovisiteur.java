package com.api.Visiteur.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Photovisiteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String photo;

}

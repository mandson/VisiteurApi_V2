package com.api.Visiteur.Mail.ressource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EmailMessage {
    private  String To;
    private String subject;
    @Lob
    private String message;


}

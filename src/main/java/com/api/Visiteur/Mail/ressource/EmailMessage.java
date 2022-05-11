package com.api.Visiteur.Mail.ressource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EmailMessage {
    private  String To;
    private String subject;
    private String message;


}

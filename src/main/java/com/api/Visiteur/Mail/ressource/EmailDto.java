package com.api.Visiteur.Mail.ressource;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;

@Builder
@Data
public class EmailDto {
    private  String To;
    private String subject;
    @Lob
    private String message;

}

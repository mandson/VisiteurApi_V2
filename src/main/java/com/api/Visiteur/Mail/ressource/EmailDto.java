package com.api.Visiteur.Mail.ressource;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmailDto {
    private  String To;
    private String subject;
    private String message;

}

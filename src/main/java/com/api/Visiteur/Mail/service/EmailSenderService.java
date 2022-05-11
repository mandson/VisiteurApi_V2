package com.api.Visiteur.Mail.service;

public interface EmailSenderService {

    void sendEmail(String To,String subject, String message);

}


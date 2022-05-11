package com.api.Visiteur.Mail.controllerMail;

import com.api.Visiteur.Mail.ressource.EmailDto;
import com.api.Visiteur.Mail.ressource.EmailMessage;
import com.api.Visiteur.Mail.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class emailController {

    public emailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping("api/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailDto emailMessage) {
          emailSenderService.sendEmail(emailMessage.getTo(),emailMessage.getMessage(),emailMessage.getSubject());


          return ResponseEntity.ok("SUCCESS");
    };
}

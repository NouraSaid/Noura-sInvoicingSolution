package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailingService mailingService;

    @PostMapping("/message")
    public ResponseEntity<Object> sendMail() {
        try {
            mailingService.sendSimpleMail();
            return ResponseEntity.ok("Mail sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send mail: " + e.getMessage());
        }
    }

    @PostMapping("/sendWithAttachment")
    public ResponseEntity<Object> sendMailWithAttachment() {
        try {
            mailingService.sendMailWithAttachment();
            return ResponseEntity.ok("Mail with attachment sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send mail with attachment: " + e.getMessage());
        }
    }
}
package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailingService mailingService;
    @PostMapping("/message")
    public String sendMail() {

       return mailingService.sendSimpleMail();
    }

}

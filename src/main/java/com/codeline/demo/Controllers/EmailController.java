package com.codeline.demo.Controllers;

import com.codeline.demo.Mail.Services.EmailService;
import com.codeline.demo.Mail.models.EmailDetalis;
import com.codeline.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "email")
public class EmailController {


    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetalis details) {
        String status = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetalis details) {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
    @Autowired
    SlackClient slackClient;
}

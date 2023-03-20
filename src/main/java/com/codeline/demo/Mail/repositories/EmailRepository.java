package com.codeline.demo.Mail.repositories;


import com.codeline.demo.Mail.models.EmailDetalis;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {
    String sendSimpleMailToMany(EmailDetalis emailDetails);
    String sendSimpleMail(EmailDetalis emailDetails);
    String sendMailWithAttachmentToMany(EmailDetalis emailDetails);
    String sendMailWithAttachment(EmailDetalis emailDetails);
}


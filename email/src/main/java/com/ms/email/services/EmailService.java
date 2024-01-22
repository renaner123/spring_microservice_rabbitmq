package com.ms.email.services;

import java.time.LocalDateTime;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;

import ch.qos.logback.classic.Logger;

@Service
public class EmailService {

    Logger logger = (Logger) LoggerFactory.getLogger(EmailService.class);

    @Autowired
    EmailRepository emailRepository;
    
    @Autowired
    JavaMailSender emailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @SuppressWarnings("finally")
	@Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        try{
            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            logger.info("Enviando email...");
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
            logger.info("Email enviado com sucesso!");
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }
    }

}
package com.ms.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;

import ch.qos.logback.classic.Logger;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(UserService.class);

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");
        logger.info("Enviando email... para: " + userModel.getEmail() );
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}

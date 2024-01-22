package com.ms.email.consumers;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dtos.EmailRecordDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;

import ch.qos.logback.classic.Logger;

@Component
@EnableRabbit
public class EmailConsumer {
	
	@Autowired
    EmailService emailService;

	Logger logger = (Logger) LoggerFactory.getLogger(EmailService.class);

	
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenerEmailQueue(@Payload EmailRecordDto emailrecordDto) {
		var emailModel = new EmailModel();
		BeanUtils.copyProperties(emailrecordDto, emailModel);
		logger.info("Email recebido da fila");
		emailService.sendEmail(emailModel);
	}
}

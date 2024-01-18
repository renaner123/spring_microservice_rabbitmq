package com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dtos.EmailRecordDto;

@Component
public class EmailConsumer {

	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenerEmailQueue(@Payload EmailRecordDto emailrecordDto) {
		System.out.println(emailrecordDto.emailTo());
	}
}

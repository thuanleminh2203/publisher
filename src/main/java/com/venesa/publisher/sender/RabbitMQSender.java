package com.venesa.publisher.sender;

import com.venesa.common.DTO.MessageDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public <T> void sender(MessageDTO<?> message, String exchange, String routingKey) {
        System.out.println("====send messs=====");
//        message.getType()
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }
}

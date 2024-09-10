package org.has.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import org.has.rabbitmq.model.AppointmentModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
    public class AppointmentProducer {
        private final RabbitTemplate rabbitTemplate;

    public void convertAndSendMessage(AppointmentModel model){
        rabbitTemplate.convertAndSend("exchange-patience","key-patience",model);
    }
    }

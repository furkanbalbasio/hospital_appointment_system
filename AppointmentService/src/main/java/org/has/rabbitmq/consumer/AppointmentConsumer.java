package org.has.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.has.rabbitmq.model.AppointmentModel;
import org.has.service.AppointmentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentConsumer {
    private final AppointmentService appointmentService;

    @RabbitListener(queues = "queue-patience-create-appointment")
    public void createAppointmentFromQueue(AppointmentModel model) {
        appointmentService.createAppointmentWithKafka(model);
    }
}

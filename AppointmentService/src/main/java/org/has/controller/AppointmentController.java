package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.service.AppointmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(APPOINTMENT)
public class AppointmentController {
    private final AppointmentService appointmentService;
}

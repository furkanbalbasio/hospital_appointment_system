package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.service.AppointmentService;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.EDepartment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.has.utility.enums.AppointmentHours;

import java.time.LocalDate;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(APPOINTMENT)
public class AppointmentController {
    private final AppointmentService appointmentService;
    @PostMapping("/save-appointment")
    public ResponseEntity<Void> save(Long patienceId, EDepartment department, Long doctorId, AppointmentDate appointmentDate, AppointmentHours appointmentHours){
        appointmentService.save(patienceId,department,doctorId,appointmentDate,appointmentHours);
        return ResponseEntity.ok().build();
    }
}
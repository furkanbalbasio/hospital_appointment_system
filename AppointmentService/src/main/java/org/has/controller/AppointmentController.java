package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.AppointmentSaveRequestDto;
import org.has.service.AppointmentService;
import org.has.utility.enums.EDepartment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(APPOINTMENT)
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/save")
    ResponseEntity<Void> save(EDepartment department, Long doctorId,AppointmentSaveRequestDto dto){
        appointmentService.save(department,doctorId,dto);
        return ResponseEntity.ok().build();
    }
}

package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.PatienceSaveRequestDto;

import org.has.repository.entity.Patience;
import org.has.service.PatienceService;

import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PATIENCE)
public class PatienceController {
    private final PatienceService patienceService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid PatienceSaveRequestDto dto){
        Patience user =   patienceService.save(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/create-appointment")
    public ResponseEntity<Void> createAppointment(@RequestParam("patienceId") Long patienceId,@RequestParam("department") EDepartment department,
                                                @RequestParam("doctorId") Long doctorId,
                                                @RequestParam("appointmentDate") AppointmentDate appointmentDate,
                                                @RequestParam("appointmentHours") AppointmentHours appointmentHours){
        patienceService.createAppointment(patienceId,department,doctorId,appointmentDate,appointmentHours);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/make-appointment")
    public ResponseEntity<Void> makeAppointment(String token,@RequestParam("department") EDepartment department,
                                                @RequestParam("doctorId") Long doctorId,
                                                @RequestParam("appointmentDate") AppointmentDate appointmentDate,
                                                @RequestParam("appointmentHours") AppointmentHours appointmentHours){
        patienceService.makeAppointment(token,department,doctorId,appointmentDate,appointmentHours);
        return ResponseEntity.ok().build();
    }
}

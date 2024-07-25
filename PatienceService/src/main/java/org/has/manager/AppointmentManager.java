package org.has.manager;

import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${my-application-patience.appointment-end-point}",name = "appointmentManager")
public interface AppointmentManager {
    @PostMapping("/save-appointment")
     ResponseEntity<Void> save(@RequestParam("patienceId") Long patienceId,
                               @RequestParam("department") EDepartment department,
                               @RequestParam("doctorId") Long doctorId,
                               @RequestParam("appointmentDate") AppointmentDate appointmentDate,
                               @RequestParam("appointmentHours") AppointmentHours appointmentHours);
}

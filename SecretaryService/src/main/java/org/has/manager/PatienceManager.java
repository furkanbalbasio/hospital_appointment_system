package org.has.manager;

import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${my-application-secretary.patience-end-point}",name = "patienceManager")
public interface PatienceManager {
    @PostMapping("/create-appointment")
     ResponseEntity<Void> createAppointment(@RequestParam("patienceId") Long patienceId,@RequestParam("department") EDepartment department,
                                                  @RequestParam("doctorId") Long doctorId,
                                                  @RequestParam("appointmentDate") AppointmentDate appointmentDate,
                                                  @RequestParam("appointmentHours") AppointmentHours appointmentHours);


}

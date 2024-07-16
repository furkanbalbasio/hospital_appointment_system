package org.has.manager;

import jakarta.validation.Valid;
import org.has.dto.AppointmentSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${my-application-appointment.appointment-end-point}",name = "appointmentManager")
public interface AppointmentManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody @Valid AppointmentSaveRequestDto dto);
}

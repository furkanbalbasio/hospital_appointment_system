package org.has.manager;

import jakarta.validation.Valid;
import org.has.dto.request.DoctorSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${my-application.doctor-end-point}",name = "doctorManager")
public interface DoctorManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody @Valid DoctorSaveRequestDto dto);
}

package org.has.manager;

import org.has.utility.enums.EDepartment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${my-application-appointment.doctor-end-point}",name = "doctorManager")
public interface DoctorManager {
    @GetMapping("/find-by-department-and-id")
    ResponseEntity<Long> findByDepartmentAndId(@RequestParam("department") EDepartment department, @RequestParam(value = "doctorId", required = false) Long doctorId);
}

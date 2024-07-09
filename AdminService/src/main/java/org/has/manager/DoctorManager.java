package org.has.manager;

import jakarta.validation.Valid;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.request.DoctorUpdateRequestDto;
import org.has.dto.response.DoctorFindAllResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "${my-application.doctor-end-point}",name = "doctorManager")
public interface DoctorManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody @Valid DoctorSaveRequestDto dto);
    @GetMapping("/find-all")
    ResponseEntity<List<DoctorFindAllResponseDto>> findAll();
    @PutMapping("/{registrationNumber}/update")
    ResponseEntity<Void> update(@PathVariable String registrationNumber,@RequestBody DoctorUpdateRequestDto dto);
    @DeleteMapping("/{registrationNumber}/delete")
    ResponseEntity<Void> delete(@PathVariable String registrationNumber);

}

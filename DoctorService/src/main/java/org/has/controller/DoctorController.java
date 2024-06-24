package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.repository.entity.Doctor;
import org.has.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOCTOR)
public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid DoctorSaveRequestDto dto){
        Doctor doctor =doctorService.save(dto);
        return ResponseEntity.ok().build();
    }
}

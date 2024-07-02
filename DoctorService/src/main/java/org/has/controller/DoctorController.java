package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.response.DoctorFindallResponseDto;
import org.has.repository.entity.Doctor;
import org.has.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/find-all")
    public ResponseEntity<List<Doctor>> findAll() {
        List<Doctor> doctors = doctorService.findAll();
        return ResponseEntity.ok(doctors);
    }
}

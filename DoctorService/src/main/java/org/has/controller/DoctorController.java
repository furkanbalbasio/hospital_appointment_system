package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.request.DoctorUpdateRequestDto;
import org.has.repository.entity.Doctor;
import org.has.service.DoctorService;
import org.has.utility.enums.EDepartment;
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
    @PutMapping("/{registrationNumber}/update")
    public ResponseEntity<Void> update(@PathVariable String registrationNumber,@RequestBody DoctorUpdateRequestDto dto){
        doctorService.update(registrationNumber,dto);
        return ResponseEntity.ok().build();
  }
    @DeleteMapping("/{registrationNumber}/delete")
    ResponseEntity<Void> delete(@PathVariable String registrationNumber){
        doctorService.delete(registrationNumber);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/find-by-department")
    ResponseEntity<List<Doctor>> findByDepartment(@RequestParam("department") EDepartment department){
        return ResponseEntity.ok(doctorService.findByDepartment(department).get());
    }
}

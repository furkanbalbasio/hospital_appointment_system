package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.SecretarySaveRequestDto;
import org.has.dto.request.SecretaryUpdateRequestDto;
import org.has.repository.entity.Secretary;
import org.has.service.SecretaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SECRETARY)
public class SecretaryController {
    private final SecretaryService secretaryService;
    @PostMapping("/save-secretary")
    public ResponseEntity<Void> save(@RequestBody @Valid SecretarySaveRequestDto dto){
        Secretary secretary =secretaryService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/find-all-secretary")
    public ResponseEntity<List<Secretary>> findAll() {
        List<Secretary> secretaries = secretaryService.findAll();
        return ResponseEntity.ok(secretaries);
    }
    @PutMapping("/{registrationNumber}/update-secretary")
    public ResponseEntity<Void> update(@PathVariable String registrationNumber,@RequestBody SecretaryUpdateRequestDto dto){
        secretaryService.update(registrationNumber,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{registrationNumber}/delete-secretary")
    ResponseEntity<Void> delete(@PathVariable String registrationNumber){
        secretaryService.delete(registrationNumber);
        return ResponseEntity.ok().build();
    }
}



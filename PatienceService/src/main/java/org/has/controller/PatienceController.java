package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.PatienceSaveRequestDto;

import org.has.repository.entity.Patience;
import org.has.service.PatienceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PATIENCE)
public class PatienceController {
    private final PatienceService patienceService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid PatienceSaveRequestDto dto){
        Patience user =   patienceService.save(dto);
        return ResponseEntity.ok().build();
    }

}

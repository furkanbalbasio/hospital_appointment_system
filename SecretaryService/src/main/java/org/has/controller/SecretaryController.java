package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.LoginRequestDto;
import org.has.dto.request.SecretarySaveRequestDto;
import org.has.dto.request.SecretaryUpdateRequestDto;
import org.has.dto.response.BaseResponseDto;
import org.has.dto.response.LoginResponseDto;
import org.has.repository.entity.Secretary;
import org.has.service.SecretaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.has.constants.RestApiUrls.*;
import static org.has.constants.RestApiUrls.LOGIN;

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
    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody @Valid LoginRequestDto dto){
        String token = secretaryService.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                .responseCode(200)
                .data(LoginResponseDto.builder()
                        .isLogin(true)
                        .token(token)
                        .build())
                .build());
    }
}



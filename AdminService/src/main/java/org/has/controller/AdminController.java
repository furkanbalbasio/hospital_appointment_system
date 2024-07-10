package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.*;
import org.has.dto.response.BaseResponseDto;
import org.has.dto.response.FindAllDoctorResponseDto;
import org.has.dto.response.FindAllSecretaryResponseDto;
import org.has.dto.response.LoginResponseDto;
import org.has.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.has.constants.RestApiUrls.*;
import static org.has.constants.RestApiUrls.LOGIN;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {
    private final AdminService adminService;
    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody @Valid LoginRequestDto dto){
        String token = adminService.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                .responseCode(200)
                .data(LoginResponseDto.builder()
                        .isLogin(true)
                        .token(token)
                        .build())
                .build());
    }
    @PostMapping(CREATEDOCTOR)
    public ResponseEntity<Void> createDoctor(String token, DoctorSaveRequestDto dto){
        adminService.createDoctor(token,dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALLDOCTOR)
    public ResponseEntity<FindAllDoctorResponseDto> findAllDoctor(String token){
        return ResponseEntity.ok(FindAllDoctorResponseDto.builder()
                        .message("basarili")
                        .statusCode(200)
                        .data(adminService.findAllDoctor(token))
                .build());
    }
    @PutMapping("/{registrationNumber}/update")
    public ResponseEntity<Void> updateDoctor(String token,@PathVariable String registrationNumber,@RequestBody DoctorUpdateRequestDto dto){
        adminService.updateDoctor(token, registrationNumber,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{registrationNumber}/delete")
    public ResponseEntity<Void> deleteDoctor(String token, @PathVariable String registrationNumber){
        adminService.deleteDoctor(token, registrationNumber);
        return ResponseEntity.ok().build();
    }

    @PostMapping(CREATESECRETARY)
    public ResponseEntity<Void> createSecretary(String token, SecretarySaveRequestDto dto){
        adminService.createSecretary(token,dto);
                return ResponseEntity.ok().build();
    }
    @GetMapping(FINDALLSECRETARY)
    public ResponseEntity<FindAllSecretaryResponseDto> findAllSecretary(String token){
        return ResponseEntity.ok(FindAllSecretaryResponseDto.builder()
                .message("basarili")
                .statusCode(200)
                .data(adminService.findAllSecretary(token))
                .build());
    }
    @PutMapping("/{registrationNumber}/update-secretary")
    public ResponseEntity<Void> updateSecretary(String token, @PathVariable String registrationNumber, @RequestBody SecretaryUpdateRequestDto dto){
        adminService.updateSecretary(token, registrationNumber,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{registrationNumber}/delete-secretary")
    public ResponseEntity<Void> deleteSecretary(String token, @PathVariable String registrationNumber){
        adminService.deleteSecretary(token, registrationNumber);
        return ResponseEntity.ok().build();
    }


    }



package org.has.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.request.LoginRequestDto;
import org.has.dto.response.BaseResponseDto;
import org.has.dto.response.DoctorFindAllResponseDto;
import org.has.dto.response.FindAllResponseDto;
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
    public ResponseEntity<FindAllResponseDto> findAllDoctor(String token){
        return ResponseEntity.ok(FindAllResponseDto.builder()
                        .message("basarili")
                        .statusCode(200)
                        .data(adminService.findAllDoctor(token))
                .build());
    }
}

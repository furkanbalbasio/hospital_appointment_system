package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.*;
import org.has.dto.response.DoctorFindAllResponseDto;
import org.has.dto.response.SecretaryFindAllResponseDto;
import org.has.exception.AdminException;
import org.has.exception.ErrorType;
import org.has.manager.DoctorManager;
import org.has.manager.SecretaryManager;
import org.has.repository.AdminRepository;
import org.has.repository.entity.Admin;
import org.has.utility.JwtTokenManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final JwtTokenManager jwtTokenManager;
    private final DoctorManager doctorManager;
    private final SecretaryManager secretaryManager;

    public String login(LoginRequestDto dto) {
        Optional<Admin> auth = adminRepository.findOptionalByUsernameAndPassword(dto.getUsermame(), dto.getPassword());
        if (auth.isEmpty()) throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);

        Optional<String> jwtToken = jwtTokenManager.createToken(auth.get().getId());
        if (jwtToken.isEmpty())
            throw new AdminException(ErrorType.TOKEN_ERROR);
        return jwtToken.get();
    }

    public void createDoctor(String token, DoctorSaveRequestDto dto) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (isAdmin) {
            doctorManager.save(dto);
        } else {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
    }
    public List<DoctorFindAllResponseDto> findAllDoctor(String token) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (!isAdmin) {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
        return doctorManager.findAll().getBody();
    }
   public void updateDoctor(String token, String registrationNumber, DoctorUpdateRequestDto dto) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (isAdmin) {
            doctorManager.update(registrationNumber,dto);
        } else {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
    }
    public void deleteDoctor(String token, String registrationNumber) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (isAdmin) {
            doctorManager.delete(registrationNumber);
        } else {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
    }
    public void createSecretary(String token, SecretarySaveRequestDto dto) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (isAdmin) {
            secretaryManager.save(dto);
        } else {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
    }
    public List<SecretaryFindAllResponseDto> findAllSecretary(String token) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (!isAdmin) {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
        return secretaryManager.findAll().getBody();
    }
    public void updateSecretary(String token, String registrationNumber, SecretaryUpdateRequestDto dto) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (isAdmin) {
            secretaryManager.update(registrationNumber,dto);
        } else {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
    }
    public void deleteSecretary(String token, String registrationNumber) {
        boolean isAdmin = jwtTokenManager.validateToken(token);
        if (isAdmin) {
            secretaryManager.delete(registrationNumber);
        } else {
            throw new AdminException(ErrorType.USERNAME_PASSWORD_ERROR);
        }
    }



}
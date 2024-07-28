package org.has.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.LoginRequestDto;
import org.has.dto.request.SecretarySaveRequestDto;
import org.has.dto.request.SecretaryUpdateRequestDto;
import org.has.exception.ErrorType;
import org.has.exception.SecretaryException;
import org.has.manager.PatienceManager;
import org.has.mapper.SecretaryMapper;
import org.has.repository.SecretaryRepository;
import org.has.repository.entity.Secretary;
import org.has.utility.JwtTokenManager;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecretaryService {
    private final SecretaryRepository secretaryRepository;
    private final JwtTokenManager jwtTokenManager;
    private final PatienceManager patienceManager;

    public Secretary save(SecretarySaveRequestDto dto) {
        Secretary secretary= secretaryRepository.save(SecretaryMapper.INSTANCE.fromDto(dto));

        return secretary;
    }

    public List<Secretary> findAll() {
        List<Secretary> secretaries = secretaryRepository.findAll();

        return secretaries;
    }

    @Transactional
    public void update(String registrationNumber, SecretaryUpdateRequestDto dto){
        Optional<Secretary> secretaryOptional = secretaryRepository.findByRegistrationNumber(registrationNumber);
        secretaryOptional.ifPresentOrElse(secretary -> {
            secretary.setEmail(dto.getEmail());
            secretary.setPhone(dto.getPhone());
            secretary.setSurname(dto.getSurname());
            secretary.setName(dto.getName());
            secretary.setPassword(dto.getPassword());
            secretaryRepository.save(secretary);
        }, () -> {
            System.out.println("bulunamadı");
        });

    }


    public void delete(String registrationNumber) {
        Optional<Secretary> secretaryOptional = secretaryRepository.findByRegistrationNumber(registrationNumber);
        secretaryOptional.ifPresentOrElse(secretary -> {
            secretaryRepository.delete(secretaryOptional.get());

        }, () -> {
            System.out.println("bulunamadı");
        });
    }
    public String login(LoginRequestDto dto) {
        Optional<Secretary> auth = secretaryRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (auth.isEmpty()) throw new SecretaryException(ErrorType.USERNAME_PASSWORD_ERROR);


        Optional<String> jwtToken = jwtTokenManager.createToken(auth.get().getId());
        if (jwtToken.isEmpty())
            throw new SecretaryException(ErrorType.TOKEN_ERROR);
        return jwtToken.get();
    }

    public void createPatienceAppointment(String token, Long patienceId, EDepartment department, Long doctorId, AppointmentDate appointmentDate, AppointmentHours appointmentHours) {
    boolean isSecretary=jwtTokenManager.validateToken(token);
    if (!isSecretary){
        throw new SecretaryException(ErrorType.SECRETARY_NOT_FOUND);
    }
    patienceManager.createAppointment(patienceId,department,doctorId,appointmentDate,appointmentHours);
    }
}


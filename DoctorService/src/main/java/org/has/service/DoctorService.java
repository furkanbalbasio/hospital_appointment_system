package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.request.DoctorUpdateRequestDto;
import org.has.dto.response.DoctorFindallResponseDto;
import org.has.mapper.DoctorMapper;
import org.has.repository.DoctorRepository;
import org.has.repository.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor save(DoctorSaveRequestDto dto) {
        Doctor doctor= doctorRepository.save(DoctorMapper.INSTANCE.fromDto(dto));
        doctor.setUuid(UUID.randomUUID()); // save den önce set etmesi gerekmiyor mu ?!
        return doctor;
    }

    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }
    public Doctor update(DoctorUpdateRequestDto dto){
        Optional<Doctor> doctorOptional = doctorRepository.findByUuid(dto.getUuid());
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
          //  doctorMapper.updateEntity(dto, doctor);
            return doctorRepository.save(doctor);
        } else {
            throw new RuntimeException("Doctor bulunamadı");
        }
    }

    }


package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.response.DoctorFindallResponseDto;
import org.has.mapper.DoctorMapper;
import org.has.repository.DoctorRepository;
import org.has.repository.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor save(DoctorSaveRequestDto dto) {
        Doctor doctor= doctorRepository.save(DoctorMapper.INSTANCE.fromDto(dto));
        return doctor;
    }

    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

//    private DoctorFindallResponseDto convertToDto(Doctor doctor) {
//        // Doctor nesnesini DoctorFindallResponseDto'ya dönüştürme işlemi
//        return new DoctorFindallResponseDto();
//    }

    }


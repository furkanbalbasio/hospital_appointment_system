package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.mapper.DoctorMapper;
import org.has.repository.DoctorRepository;
import org.has.repository.entity.Doctor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor save(DoctorSaveRequestDto dto) {
        Doctor doctor= doctorRepository.save(DoctorMapper.INSTANCE.fromDto(dto));
        return doctor;
    }
}

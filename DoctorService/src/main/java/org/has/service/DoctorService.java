package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.request.DoctorUpdateRequestDto;
import org.has.exception.DoctorException;
import org.has.exception.ErrorType;
import org.has.mapper.DoctorMapper;
import org.has.repository.DoctorRepository;
import org.has.repository.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor save(DoctorSaveRequestDto dto) {
        Doctor doctor= doctorRepository.save(DoctorMapper.INSTANCE.fromDto(dto));
//        doctor.setUuid(UUID.randomUUID()); // save den önce set etmesi gerekmiyor mu ?!
        return doctor;
    }

    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }


  public void update(String registrationNumber, DoctorUpdateRequestDto dto){
      Optional<Doctor> doctorOptional = doctorRepository.findByRegistrationNumber(registrationNumber);
       if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
           doctorRepository.save(doctor);
        } else {
           System.out.println("bulunamadı");
        }
    }

    }


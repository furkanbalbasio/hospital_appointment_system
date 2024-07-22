package org.has.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.request.DoctorUpdateRequestDto;
import org.has.exception.DoctorException;
import org.has.exception.ErrorType;
import org.has.mapper.DoctorMapper;
import org.has.repository.DoctorRepository;
import org.has.repository.entity.Doctor;
import org.has.utility.enums.EDepartment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

@Transactional
  public void update(String registrationNumber,DoctorUpdateRequestDto dto){
      Optional<Doctor> doctorOptional = doctorRepository.findByRegistrationNumber(registrationNumber);
      doctorOptional.ifPresentOrElse(doctor -> {
          doctor.setDepartment(dto.getDepartment());
          doctor.setEmail(dto.getEmail());
          doctor.setPhone(dto.getPhone());
          doctorRepository.save(doctor);
      }, () -> {
          System.out.println("bulunamadı");
      });
        }


    public void delete(String registrationNumber) {
        Optional<Doctor> doctorOptional = doctorRepository.findByRegistrationNumber(registrationNumber);
        doctorOptional.ifPresentOrElse(doctor -> {
            doctorRepository.delete(doctorOptional.get());
        }, () -> {
            System.out.println("bulunamadı");
        });
    }


    public Long findByDepartmentAndId(EDepartment department, Long doctorId) {
        Optional<List<Doctor>> doctorListOpt = doctorRepository.findByDepartment(department);
        if (!doctorListOpt.isPresent() || doctorListOpt.get().isEmpty()) {
            throw new  DoctorException(ErrorType.BAD_REQUEST_ERROR);
        }
        List<Doctor> doctorList = doctorListOpt.get();
        Optional<Doctor> doctorOpt = doctorList.stream()
                .filter(doctor -> doctor.getId().equals(doctorId))
                .findFirst();
        if (!doctorOpt.isPresent()) {
            throw new DoctorException(ErrorType.BAD_REQUEST_ERROR);
        }
        return doctorOpt.get().getId();
    }
}


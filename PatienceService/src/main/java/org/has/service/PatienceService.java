package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.PatienceSaveRequestDto;
import org.has.dto.response.DoctorResponseDto;
import org.has.manager.DoctorManager;
import org.has.mapper.PatienceMapper;
import org.has.repository.PatienceRepository;
import org.has.repository.entity.Patience;
import org.has.utility.enums.EDepartment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatienceService {
    private final PatienceRepository patienceRepository;
    private final DoctorManager doctorManager;
    public Patience save(PatienceSaveRequestDto dto) {
        Patience patience=patienceRepository.save(PatienceMapper.INSTANCE.fromDto(dto));
        return patience;
    }
    public List<DoctorResponseDto> findByDepartment(EDepartment department){
       return doctorManager.findByDepartment(department).getBody();
    }
    
}

package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.PatienceSaveRequestDto;
import org.has.mapper.PatienceMapper;
import org.has.repository.PatienceRepository;
import org.has.repository.entity.Patience;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatienceService {
    private final PatienceRepository patienceRepository;

    public Patience save(PatienceSaveRequestDto dto) {
        Patience patience=patienceRepository.save(PatienceMapper.INSTANCE.fromDto(dto));
        return patience;
    }
}

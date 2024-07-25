package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.PatienceSaveRequestDto;
import org.has.exception.ErrorType;
import org.has.exception.PatienceException;
import org.has.manager.AppointmentManager;
import org.has.mapper.PatienceMapper;
import org.has.repository.PatienceRepository;
import org.has.repository.entity.Patience;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatienceService {
    private final PatienceRepository patienceRepository;
    private final AppointmentManager appointmentManager;
    public Patience save(PatienceSaveRequestDto dto) {
        Patience patience=patienceRepository.save(PatienceMapper.INSTANCE.fromDto(dto));
        return patience;
    }


        public void makeAppointment(Long patienceId, EDepartment department, Long doctorId, AppointmentDate appointmentDate, AppointmentHours appointmentHours) {
            Optional<Patience> patience=patienceRepository.findById(patienceId);
            if (patience.isEmpty()){
                throw new PatienceException(ErrorType.HASTA_BULUNMAMAKTADIR);
            }
                appointmentManager.save(patienceId, department, doctorId, appointmentDate, appointmentHours);
            }
}

package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.PatienceSaveRequestDto;
import org.has.exception.ErrorType;
import org.has.exception.PatienceException;
import org.has.rabbitmq.model.AppointmentModel;
import org.has.rabbitmq.producer.AppointmentProducer;
import org.has.mapper.PatienceMapper;
import org.has.repository.PatienceRepository;
import org.has.repository.entity.Patience;
import org.has.utility.JwtTokenManager;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatienceService {
    private final PatienceRepository patienceRepository;
//    private final AppointmentManager appointmentManager;
    private final JwtTokenManager jwtTokenManager;
    private final AppointmentProducer appointmentProducer;

    public Patience save(PatienceSaveRequestDto dto) {
        Patience patience=patienceRepository.save(PatienceMapper.INSTANCE.fromDto(dto));
        return patience;
    }


        public void makeAppointment(String token,EDepartment department, Long doctorId, AppointmentDate appointmentDate, AppointmentHours appointmentHours) {
            boolean isPatience = jwtTokenManager.validateToken(token);
            if (!isPatience) {
                throw new PatienceException(ErrorType.USERNAME_PASSWORD_ERROR);
            }
            Long patienceIdFromToken=jwtTokenManager.getIdByToken(token).get();
//                Optional<Patience> patience=patienceRepository.findById(patienceIdFromToken);
//                if (patience.isEmpty()){
//                    throw new PatienceException(ErrorType.HASTA_BULUNMAMAKTADIR);
//                }
//                appointmentManager.save(patienceIdFromToken, department, doctorId, appointmentDate, appointmentHours);
            AppointmentModel appointmentModel= AppointmentModel.builder()
                    .doctorId(doctorId)
                    .appointmentDate(appointmentDate)
                    .appointmentHours(appointmentHours)
                    .patienceId(patienceIdFromToken)
                    .department(department)
                    .build();
            appointmentProducer.convertAndSendMessage(appointmentModel);
    }


    public void createAppointment(Long patienceId, EDepartment department, Long doctorId, AppointmentDate appointmentDate, AppointmentHours appointmentHours) {
        boolean isPatience=patienceRepository.existsById(patienceId);
        if (!isPatience){
            throw new PatienceException(ErrorType.HASTA_BULUNMAMAKTADIR);
        }
        AppointmentModel appointmentModel= AppointmentModel.builder()
                .doctorId(doctorId)
                .appointmentDate(appointmentDate)
                .appointmentHours(appointmentHours)
                .patienceId(patienceId)
                .department(department)
                .build();
        appointmentProducer.convertAndSendMessage(appointmentModel);
//        appointmentManager.save(patienceId,department,doctorId,appointmentDate,appointmentHours);
    }
}

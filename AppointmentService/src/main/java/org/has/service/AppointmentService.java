package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.dto.request.AppointmentSaveRequestDto;
import org.has.repository.AppointmentRepository;
import org.has.repository.entity.Appointment;
import org.has.utility.enums.EDepartment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public void save(EDepartment department,Long doctorId,AppointmentSaveRequestDto dto) {
        Appointment appointment= Appointment.builder()
                .appointmentDate(dto.getAppointmentDate())
                .state(dto.isState())
                .department(department)
                .doctorId(doctorId)
                .build();
        appointmentRepository.save(appointment);
    }
}

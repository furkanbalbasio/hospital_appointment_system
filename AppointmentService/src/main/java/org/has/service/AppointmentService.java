package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.exception.AppointmentException;
import org.has.exception.ErrorType;
import org.has.manager.DoctorManager;
import org.has.repository.AppointmentDetailsRepository;
import org.has.repository.AppointmentRepository;
import org.has.repository.entity.Appointment;
import org.has.repository.entity.AppointmentDetails;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentDetailsRepository appointmentDetailsRepository;
    private final DoctorManager doctorManager;

    public void save(Long patienceId, EDepartment department, Long doctorId, AppointmentDate appointmentDate, AppointmentHours appointmentHours) {
        Long doctorId2 = doctorManager.findByDepartmentAndId(department, doctorId).getBody();

        if (doctorId2 == null) {
            throw new AppointmentException(ErrorType.DOKTOR_BULUNMAMAKTADIR);
        }

        AppointmentDetails existingAppointmentDetails = appointmentDetailsRepository.findByDoctorIdAndAppointmentDateAndAppointmentHours(doctorId2, appointmentDate, appointmentHours);

        if (existingAppointmentDetails != null && existingAppointmentDetails.isBooked()) {
            throw new AppointmentException(ErrorType.RANDEVU_DOLU);
        }

        AppointmentDetails appointmentDetails = AppointmentDetails.builder()
                .appointmentDate(appointmentDate)
                .appointmentHours(appointmentHours)
                .doctorId(doctorId2)
                .build();

        appointmentDetailsRepository.save(appointmentDetails);

        Appointment appointment = Appointment.builder()
                .appointmentDetailsId(appointmentDetails.getId())
                .patienceId(patienceId)
                .build();

        appointmentRepository.save(appointment);
        appointmentDetails.setBooked(true);
        appointmentDetailsRepository.save(appointmentDetails);
    }
}

package org.has.repository;

import org.has.repository.entity.AppointmentDetails;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails, Long> {
    AppointmentDetails findByDoctorIdAndAppointmentDateAndAppointmentHours(Long doctorId2, AppointmentDate appointmentDate, AppointmentHours appointmentHours);
}

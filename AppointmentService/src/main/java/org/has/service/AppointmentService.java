package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
}

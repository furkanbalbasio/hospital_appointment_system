package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
}

package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.repository.PatienceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatienceService {
    private final PatienceRepository patienceRepository;
}

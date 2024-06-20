package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.repository.SecretaryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecretaryService {
    private final SecretaryRepository secretaryRepository;
}

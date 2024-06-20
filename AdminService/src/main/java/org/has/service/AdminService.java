package org.has.service;

import lombok.RequiredArgsConstructor;
import org.has.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
}

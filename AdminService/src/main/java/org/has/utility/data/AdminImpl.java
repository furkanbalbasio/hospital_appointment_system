package org.has.utility.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.has.repository.AdminRepository;
import org.has.repository.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
    @Component
    @RequiredArgsConstructor
    public class AdminImpl {
        private final AdminRepository adminRepository;

        @PostConstruct
        public void createSampleAdmin(){
            List<Admin> admins=new ArrayList<>();
            Admin admin1= Admin.builder()
                    .username("admin1")
                    .password("123456")
                    .build();
            admins.add(admin1);
            adminRepository.saveAll(admins);
        }
    }


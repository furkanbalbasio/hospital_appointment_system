package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.service.DoctorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOCTOR)
public class DoctorController {
    private final DoctorService doctorService;
}

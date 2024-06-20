package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.service.PatienceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PATIENCE)
public class PatienceController {
    private final PatienceService patienceService;
}

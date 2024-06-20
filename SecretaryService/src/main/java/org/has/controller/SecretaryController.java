package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.service.SecretaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SECRETARY)
public class SecretaryController {
    private final SecretaryService secretaryService;
}

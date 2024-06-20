package org.has.controller;

import lombok.RequiredArgsConstructor;
import org.has.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.has.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {
    private final AdminService adminService;
}

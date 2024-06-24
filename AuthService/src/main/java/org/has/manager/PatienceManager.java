package org.has.manager;

import jakarta.validation.Valid;
import org.has.dto.request.PatienceSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${my-application.patience-end-point}",name = "patienceManager")
public interface PatienceManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody @Valid PatienceSaveRequestDto dto);
}

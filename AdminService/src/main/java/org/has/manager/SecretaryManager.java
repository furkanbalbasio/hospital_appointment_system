package org.has.manager;
import jakarta.validation.Valid;
import org.has.dto.request.SecretarySaveRequestDto;
import org.has.dto.request.SecretaryUpdateRequestDto;
import org.has.dto.response.SecretaryFindAllResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "${my-application-s.secretary-end-point}",name = "secretaryManager")
public interface SecretaryManager {
    @PostMapping("/save-secretary")
    ResponseEntity<Void> save(@RequestBody @Valid SecretarySaveRequestDto dto);
    @GetMapping("/find-all-secretary")
    ResponseEntity<List<SecretaryFindAllResponseDto>> findAll();
    @PutMapping("/{registrationNumber}/update-secretary")
    ResponseEntity<Void> update(@PathVariable String registrationNumber, @RequestBody SecretaryUpdateRequestDto dto);
    @DeleteMapping("/{registrationNumber}/delete-secretary")
    ResponseEntity<Void> delete(@PathVariable String registrationNumber);


}

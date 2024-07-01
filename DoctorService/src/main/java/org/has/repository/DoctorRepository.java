package org.has.repository;

import org.has.dto.response.DoctorFindallResponseDto;
import org.has.repository.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}

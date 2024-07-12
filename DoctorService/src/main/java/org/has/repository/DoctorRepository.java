package org.has.repository;

import org.has.repository.entity.Doctor;
import org.has.utility.enums.EDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
//    Optional<Doctor> findByUuid(UUID uuid);
Optional<Doctor> findByRegistrationNumber(String registrationNumber); // Sicil numarasına göre doktor bulmak için
Optional<List<Doctor>> findByDepartment(EDepartment department);
}

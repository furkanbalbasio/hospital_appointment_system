package org.has.repository;

import org.has.repository.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
//    Optional<Doctor> findByUuid(UUID uuid);
Optional<Doctor> findByRegistrationNumber(String registrationNumber); // Sicil numarasına göre doktor bulmak için

}

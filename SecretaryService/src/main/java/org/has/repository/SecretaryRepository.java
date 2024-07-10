package org.has.repository;

import org.has.repository.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecretaryRepository extends JpaRepository<Secretary,Long> {
    Optional<Secretary> findByRegistrationNumber(String registrationNumber);
}

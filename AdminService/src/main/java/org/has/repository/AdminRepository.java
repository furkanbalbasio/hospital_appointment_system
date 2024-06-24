package org.has.repository;

import org.has.repository.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findOptionalByUserNameAndPassword(String userName, String password);
}

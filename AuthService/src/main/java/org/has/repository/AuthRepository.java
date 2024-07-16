package org.has.repository;


import org.has.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth> findOptionalByTcNumberAndPassword(String tcNumber, String password);

    Optional<Auth> findOptionalByTcNumber(String tcNumber);
}

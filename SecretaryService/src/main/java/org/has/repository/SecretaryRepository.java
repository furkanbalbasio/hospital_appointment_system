package org.has.repository;

import org.has.repository.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<Secretary,Long> {
}

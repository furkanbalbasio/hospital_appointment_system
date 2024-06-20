package org.has.repository;

import org.has.repository.entity.Patience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatienceRepository extends JpaRepository<Patience,Long> {
}

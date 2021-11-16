package com.ayupovmi.pmapp.repository;
/**
 * Repository interface for {@link StatusEntity} class.
 */

import com.ayupovmi.pmapp.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
    Optional<StatusEntity> findById(Long statusId);
    Optional<StatusEntity> save ();
}

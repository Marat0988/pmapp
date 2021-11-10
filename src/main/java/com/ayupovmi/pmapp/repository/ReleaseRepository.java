package com.ayupovmi.pmapp.repository;

import com.ayupovmi.pmapp.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Long> {
    Optional<ReleaseEntity> findById(Long releaseId);
    Optional<ReleaseEntity> save ();

}
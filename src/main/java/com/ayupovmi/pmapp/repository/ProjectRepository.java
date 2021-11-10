package com.ayupovmi.pmapp.repository;

import com.ayupovmi.pmapp.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

/**
 * Repository interface for {@link ProjectEntity} class.
 */
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findById(Long projectId);
    Optional<ProjectEntity> save ();

}

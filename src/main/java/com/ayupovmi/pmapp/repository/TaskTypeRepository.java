package com.ayupovmi.pmapp.repository;
/**
 * Repository interface for {@link TaskType} class.
 */

import com.ayupovmi.pmapp.entity.TaskTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskTypeRepository extends JpaRepository<TaskTypeEntity, Long>{
    Optional<TaskTypeEntity> findById(Long taskTypeId);
    Optional<TaskTypeEntity> save ();
}

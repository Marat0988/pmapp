package com.ayupovmi.pmapp.repository;
/**
 * Repository interface for {@link TaskEntity} class.
*/


import com.ayupovmi.pmapp.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findById(Long taskId);
    Optional<TaskEntity> save ();
}

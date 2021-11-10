package com.ayupovmi.pmapp.repository;
/**
 * Repository interface for {@link userEntity} class.
 */

import com.ayupovmi.pmapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long TaskId);
    Optional<UserEntity> save ();
}

package com.ayupovmi.pmapp.repository;

import com.ayupovmi.pmapp.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findById(Long roleId);
    Optional<RoleEntity> save ();
}

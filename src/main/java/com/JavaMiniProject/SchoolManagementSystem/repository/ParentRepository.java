package com.JavaMiniProject.SchoolManagementSystem.repository;

import com.JavaMiniProject.SchoolManagementSystem.model.Parent;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParentRepository extends CrudRepository<Parent, UUID> {
    Optional<Parent> findByEmail(String email);
    boolean existsByEmail(String email);

}

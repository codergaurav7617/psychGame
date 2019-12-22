package com.psych.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<EmployeeRepository,Long> {
}

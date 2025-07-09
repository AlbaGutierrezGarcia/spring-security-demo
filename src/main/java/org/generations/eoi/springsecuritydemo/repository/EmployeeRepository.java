package org.generations.eoi.springsecuritydemo.repository;

import org.generations.eoi.springsecuritydemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByUsername(String username);
}


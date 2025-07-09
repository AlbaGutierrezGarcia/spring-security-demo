package org.generations.eoi.springsecuritydemo.repository;

import org.generations.eoi.springsecuritydemo.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long> {

}

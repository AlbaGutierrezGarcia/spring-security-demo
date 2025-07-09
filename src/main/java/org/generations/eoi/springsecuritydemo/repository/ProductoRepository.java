package org.generations.eoi.springsecuritydemo.repository;

import org.generations.eoi.springsecuritydemo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

package com.cibertec.restaurante.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.restaurante.security.entity.Rol;
import com.cibertec.restaurante.security.enums.RolNombre;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

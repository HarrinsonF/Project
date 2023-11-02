package com.example.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	long countByDescripcion(String descripcion);
}

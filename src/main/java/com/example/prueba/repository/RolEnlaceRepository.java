package com.example.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.prueba.entity.Enlace;
import com.example.prueba.entity.Rol;
import com.example.prueba.entity.RolEnlace;

public interface RolEnlaceRepository extends JpaRepository<RolEnlace, Integer>{
	
	@Query("SELECT COUNT(re) > 0 FROM RolEnlace re WHERE re.rol = :rol AND re.enlace = :enlace")
    boolean existsByRolAndEnlace(Rol rol, Enlace enlace);
}

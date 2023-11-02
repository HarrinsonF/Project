package com.example.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.prueba.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	@Query("SELECT COUNT(d) > 0 FROM Doctor d WHERE d.cmp = :cmp")
	boolean cmpExiste(String cmp);
}

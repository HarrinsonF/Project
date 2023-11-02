package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Especialidad;
import com.example.prueba.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
	@Autowired
	private EspecialidadRepository repo;
	
	public List<Especialidad> listarEspe(){
		return repo.findAll();
	}
}

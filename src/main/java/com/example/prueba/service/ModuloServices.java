package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Modulo;
import com.example.prueba.repository.ModuloRepository;

@Service
public class ModuloServices {
	@Autowired
	private ModuloRepository repo;
	
	public List<Modulo>listarTodos(){
		return repo.findAll();
	}
	
	

}

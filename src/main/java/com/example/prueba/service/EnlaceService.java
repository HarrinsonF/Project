package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Enlace;
import com.example.prueba.repository.EnlaceRepository;


@Service
public class EnlaceService {

	@Autowired
	private EnlaceRepository repo;
	
	public List<Enlace> listarTodos(){
		return repo.findAll();
	}
	
	public Enlace buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}

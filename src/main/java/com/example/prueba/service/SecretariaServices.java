package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Secretaria;
import com.example.prueba.repository.SecretariaRepository;

@Service
public class SecretariaServices {
	
	@Autowired
	private SecretariaRepository repo;
	
	
	public void registrar(Secretaria se){
		repo.save(se);
	}
	public void actualizar(Secretaria se) {
		repo.save(se);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Secretaria buscarporID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Secretaria>listarTodos(){
		return repo.findAll();
	}
}

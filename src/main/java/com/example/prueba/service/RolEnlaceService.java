package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Enlace;
import com.example.prueba.entity.Rol;
import com.example.prueba.entity.RolEnlace;
import com.example.prueba.repository.RolEnlaceRepository;

@Service
public class RolEnlaceService {
	
	@Autowired
	private RolEnlaceRepository repo;
	
	public void registrar(RolEnlace r) {
		repo.save(r);
	}
	
	public void actualizar(RolEnlace r) {
		repo.save(r);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public RolEnlace buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<RolEnlace> listarTodos(){
		return repo.findAll();
	}
	
	public boolean esCombinacionCodigosDuplicada(Rol rol, Enlace enlace) {
        return repo.existsByRolAndEnlace(rol, enlace);
    }

}

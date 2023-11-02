package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Rol;
import com.example.prueba.repository.RolRepository;

@Service
public class RolService {

	@Autowired
	private RolRepository repo;
	
	public void registrar(Rol r) {
		repo.save(r);
	}
	
	public void actualizar(Rol r) {
		repo.save(r);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Rol buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Rol> listarTodos(){
		return repo.findAll();
	}
	
	public boolean esDescripcionRolDuplicada(String descripcion) {
        // Utiliza el método del repositorio para contar la cantidad de registros con la misma descripción.
        long count = repo.countByDescripcion(descripcion);
        // Si count es mayor que 0, significa que ya existe un rol con la misma descripción.
        return count > 0;
    }
}

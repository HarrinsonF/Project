package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Usuario;
import com.example.prueba.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario sesionUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	public void registrar(Usuario us) {
		repo.save(us);
	}
	public List<Usuario> listarUsu(){
		return repo.findAll();
	}
	public void actualizar(Usuario usu) {
		repo.save(usu);
	}
	public Usuario obtenerPoId(Integer usu) {
		return repo.findById(usu).orElse(null);
	}
	public void eliminar(Integer usu) {
		repo.deleteById(usu);
	}
}

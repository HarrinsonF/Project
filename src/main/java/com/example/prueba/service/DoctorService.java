package com.example.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.Doctor;
import com.example.prueba.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository repo;
	
	public void registrar(Doctor doc) {
		repo.save(doc);
	}
	public void actualizar(Doctor doc) {
		repo.save(doc);
	}
	public List<Doctor> listarDoc(){
		return repo.findAll();
	}
	public void eliminar(Integer doc) {
		repo.deleteById(doc);
	}
	public Doctor obtenerPorId(Integer doc) {
		return repo.findById(doc).orElse(null);
	}
	public boolean cmpExiste(String cmp) {
		return repo.cmpExiste(cmp);
	}
}

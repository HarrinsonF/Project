package com.example.prueba.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_especialidad")
	private Integer codigo;
	@Column(name="nom_especialidad")
	private String nombre;
	@JsonIgnore
	@OneToMany(mappedBy = "esp")
	private List<Doctor> listaDoctores;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Doctor> getListaDoctores() {
		return listaDoctores;
	}
	public void setListaDoctores(List<Doctor> listaDoctores) {
		this.listaDoctores = listaDoctores;
	}
	
	
	
	
}

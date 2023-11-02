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
@Table(name="modulo")
public class Modulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_modulo")
	private Integer codigo;
	@Column(name="nom_modulo")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "modulo")
	private List<Secretaria> listaTipoModulo;

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

	public List<Secretaria> getListaTipoModulo() {
		return listaTipoModulo;
	}

	public void setListaTipoModulo(List<Secretaria> listaTipoModulo) {
		this.listaTipoModulo = listaTipoModulo;
	}

}

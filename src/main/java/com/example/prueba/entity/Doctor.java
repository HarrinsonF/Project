package com.example.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_doctor")
	private Integer codigo;
	@Column(name="nom_doctor")
	private String nombre;
	@Column(name="ape_doctor")
	private String apellido;
	@Column(name="edad_doctor")
	private int edad;
	@Column(name="email_doctor")
	private String email;
	@Column(name="cmp_doctor")
	private String cmp;
	
	@ManyToOne
	@JoinColumn(name="cod_especialidad")
	private Especialidad esp;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Especialidad getEsp() {
		return esp;
	}

	public void setEsp(Especialidad esp) {
		this.esp = esp;
	}
	
	
}

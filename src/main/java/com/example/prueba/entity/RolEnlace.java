package com.example.prueba.entity;


import jakarta.persistence.*;
@Entity
@Table(name="acceso")
public class RolEnlace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;
	
	//atributo de la clase RolEnlacePK
	//@EmbeddedId 
	//private RolEnlacePK id;
	
	@ManyToOne
	@JoinColumn(name = "id_Rol"/*,insertable = false,updatable = false,referencedColumnName ="idrol"*/)
	private Rol rol;

	
	@ManyToOne
	@JoinColumn(name="id_Enlace"/*,insertable = false,updatable = false,referencedColumnName = "idenlace"*/)
	private Enlace enlace;


	

	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Enlace getEnlace() {
		return enlace;
	}


	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}


/*	public RolEnlacePK getId() {
		return id;
	}


	public void setId(RolEnlacePK id) {
		this.id = id;
	}*/


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
}
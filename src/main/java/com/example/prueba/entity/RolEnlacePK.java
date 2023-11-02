package com.example.prueba.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable //anotacion porque la clase va formar parte de un atributo de otra clase
public class RolEnlacePK{

	//los atributos tienen que ser el mismo nombre de la llave primaria compuesta de la bd
	private int id_Rol;
	private int id_Enlace;
	// hash code --genera un numero unico de la combinacion de los atributos
	@Override
	public int hashCode() {
		return Objects.hash(id_Enlace, id_Rol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return id_Enlace == other.id_Enlace && id_Rol == other.id_Rol;
	}
	public int getIdrol() {
		return id_Rol;
	}
	public void setIdrol(int idrol) {
		this.id_Rol = idrol;
	}
	public int getIdenlace() {
		return id_Enlace;
	}
	public void setIdenlace(int idenlace) {
		this.id_Enlace = idenlace;
	}	
}

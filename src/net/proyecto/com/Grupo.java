/**
 * 
 */
package net.proyecto.com;

import java.util.Date;

/**
 * @author Pedro
 *
 */
public class Grupo {
	private int idGrupo;
	private String nombre;
	private Date fechaCreacion;
	
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {

		this.fechaCreacion = fechaCreacion;
	}
	
	@Override
	
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nombre=" + nombre + ", fechaCreacion="
				+ fechaCreacion + "]";
	}
	
	
	public Grupo(String nombre) {
		this.nombre = nombre;
		this.fechaCreacion = new Date();
	}
	
	
	
	
	
	
	
	
	}

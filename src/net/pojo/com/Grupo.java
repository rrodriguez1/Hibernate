/**
 * 
 */
package net.pojo.com;

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
		return "[" + idGrupo + "]" + nombre ;
	}
	
	
	public Grupo(String nombre) {
		this.nombre = nombre;
		this.fechaCreacion = new Date();
	}
	
	public Grupo(){};
	
	
	
	
	
	
	}

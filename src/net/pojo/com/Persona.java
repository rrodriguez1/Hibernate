package net.pojo.com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Persona {

	private int idPersona;
	private String nombre;
	private String apellidos;
	private String direccion;
	private Date fechaNacimiento;
	private Date fechaAlta;
	private List twitts;
	private String idPais;
	
	
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public List<Twitt> getTwitts() {
		return twitts;
	}
	public String getIdPais() {
		return idPais;
	}
	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

// 4.2.21
	

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", fechaNacimiento=" + fechaNacimiento + ", fechaAlta=" + fechaAlta + ", idPais=" + idPais
				+ "]";
	}
	

	
	public Persona(String nombre, String apellidos, String direccion, Date fechaNacimiento, String idPais) 
	{
		nombre = nombre;
		apellidos = apellidos;
		direccion = direccion;
		fechaNacimiento = fechaNacimiento;
		twitts = new ArrayList<Twitt>();
		this.idPais = idPais;
		fechaAlta = new Date();
	}
	
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setTwitts(List<Twitt> twitts) {
		this.twitts = twitts;
	}
	public void Twitt(String msg){
		twitts.add(new Twitt(idPersona,msg));
	}
	
	
}

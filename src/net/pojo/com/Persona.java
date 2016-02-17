package net.pojo.com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persona {

	private int idPersona;
	private String nombre;
	private String apellidos;
	private String direccion;
	private Date fechaNacimiento;
	private Date fechaAlta;
	private List twitts;
	private Pais pais;
	private Set Grupos;
	private Configuracion configuracion;

	public Configuracion getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

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
	public Pais getIdPais() {
		return pais;
	}
	public Set getGrupos() {
		return Grupos;
	}
	public void setGrupos(Set grupos) {
		Grupos = grupos;
	}
	public void setIdPais(Pais idPais) {
		this.pais = idPais;
	}
	@Override
	public String toString() {
		return "[" + idPersona + "]" + nombre +" "+apellidos;
	}
	public Persona(String nombre, String apellidos, String direccion, Date fechaNacimiento, Pais pais) 
	{
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		twitts = new ArrayList<Twitt>();
		this.pais = pais;
		this.fechaAlta = new Date();
		this.Grupos = new HashSet();
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setTwitts(List<Twitt> twitts) {
		this.twitts = twitts;
	}
	public void Twitt(String msg){
		twitts.add(new Twitt(this.idPersona,msg));
	}
	public void Configuracion(String estado,String fondo, Boolean privado){
		this.configuracion = new Configuracion(this.idPersona,estado,fondo,privado);
	}
	
	public void addGrupo(Grupo grupo){
		this.Grupos.add(grupo);
	}
	
	public String ShowAllTwitts(){
		String result = "";
		for(int i =0; i<twitts.size();i++){
			result += "["+i+"]"+twitts.get(i).toString()+'\n';
		}
		return result;
	}
	public Persona(){}
	
	
}

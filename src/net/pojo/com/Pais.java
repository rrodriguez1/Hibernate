package net.pojo.com;

public class Pais {

	private int idPais;
	private String nombre;
	private String paIso;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaIso() {
		return paIso;
	}
	public void setPaIso(String paIso) {
		this.paIso = paIso;
	}
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", paIso=" + paIso + "]";
	}
	public Pais(String nombre, String paIso) {
		this.nombre = nombre;
		this.paIso = paIso.toLowerCase();
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	
	public Pais(){}
	
	
	
}

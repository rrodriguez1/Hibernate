package net.proyecto.com;

public class Twitt {
	private int id;
	private int idPersona;
	private String Texto;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	@Override
	public String toString() {
		return "Twitt [idPersona=" + idPersona + ", Texto=" + Texto + "]";
	}
	public Twitt(int idPersona2, String texto) {
		this.idPersona = idPersona2;
		Texto = texto;
	}
	
	
	
	
}

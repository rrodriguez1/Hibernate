package net.pojo.com;

public class Twitt {
	private int id;
	private int idPersona;
	private String Texto;
	private int idx;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
		return  Texto ;
	}
	public Twitt(int idPersona2, String texto) {
		this.idPersona = idPersona2;
		this.Texto = texto;
	}
	
	public String Show()
	{
		return "["+this.id+"]"+Texto;
	}
}

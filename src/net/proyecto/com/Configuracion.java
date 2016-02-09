/**
 * 
 */
package net.proyecto.com;

/**
 * @author Pedro
 *
 */
public class Configuracion {
    private int IdConfiguracion;
    private int IdPersona;
    private String Estado;
    private String Fondo;
    private Boolean Privado;
	@Override
	public String toString() {
		return "Configuracion [IdConfiguracion=" + IdConfiguracion + ", IdPersona=" + IdPersona + ", Estado=" + Estado
				+ ", Fondo=" + Fondo + ", Privado=" + Privado + "]";
	}
	public int getIdConfiguracion() {
		return IdConfiguracion;
	}
	public void setIdConfiguracion(int idConfiguracion) {
		IdConfiguracion = idConfiguracion;
	}
	public int getIdPersona() {
		return IdPersona;
	}
	public void setIdPersona(int idPersona) {
		IdPersona = idPersona;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getFondo() {
		return Fondo;
	}
	public void setFondo(String fondo) {
		Fondo = fondo;
	}
	public Boolean getPrivado() {
		return Privado;
	}
	public void setPrivado(Boolean privado) {
		Privado = privado;
	}
	public Configuracion(int idPersona, String estado, String fondo, Boolean privado) {
		IdPersona = idPersona;
		Estado = estado;
		Fondo = fondo;
		Privado = privado;
	}
    
    
}

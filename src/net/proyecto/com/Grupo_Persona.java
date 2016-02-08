/**
 * 
 */
package net.proyecto.com;

/**
 * @author Pedro
 *
 */
public class Grupo_Persona {
	private int idGrupo;
	private int idGrupoPersona;
	private int idPersona;
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public int getIdGrupoPersona() {
		return idGrupoPersona;
	}
	public void setIdGrupoPersona(int idGrupoPersona) {
		this.idGrupoPersona = idGrupoPersona;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	@Override
	public String toString() {
		return "Grupo_Persona [idGrupoPersona=" + idGrupoPersona + ", idPersona=" + idPersona + "]";
	}
	public Grupo_Persona(int idGrupoPersona, int idPersona) {
		this.idGrupoPersona = idGrupoPersona;
		this.idPersona = idPersona;
	}
	
	
	
	
	
}

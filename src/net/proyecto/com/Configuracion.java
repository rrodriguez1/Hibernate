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
    private Binary Imagen;
    private String Estado;
    private String Fondo;
    private Boolean Privado;
    
    Public Configuracion(final int IdConfiguracion, 
                            final int IdPersona, 
                            final Binary Imagen, 
                            final String Estado,
                            final String Fondo,
                            final Boolean Privado){
                                
        this.IdConfiguracion = IdConfiguracion;
        this.IdPersona = IdPersona;
        this.Imagen = Imagen;
        this.Estado = Estado;
        this.Fondo = Fondo;
        this.Privado = privado;
    }
}

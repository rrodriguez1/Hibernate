/**
 * 
 */
package net.test.com;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction; 
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


import net.pojo.com.*;
/**
 * @author Peter
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	
	public SessionFactory sf;
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		// pais test para hacer inserts el la base de datos
		Pais paisTest = new Pais("Espanya","ESP");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date nacimiento = sdf.parse("21/02/1994");
		Grupo perroflautas = new Grupo("perroflautas");
		Persona pedro = new Persona("Pedro","L�pez","Santfe city",nacimiento,"esp");
		pedro.Twitt("La cosa esta muy mal ");
		pedro.Twitt("Java caca");
		pedro.Twitt("Ah julan! :(");
		pedro.addGrupo(perroflautas);
		pedro.Configuracion("EN LINEA","AZUL",false);
		
		// Configuracion hibernate
		
		Configuration c=new Configuration();

        c.configure();
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
        SessionFactory sf=c.buildSessionFactory(sr);   
        Session session = sf.openSession(); // abrir session, para cerrarla session.close()? p sf.close() o algo asi , probar
        
        Transaction tx = null; // result de la query
        
        try{
        	tx = session.beginTransaction();
        	session.save(paisTest);
        	session.save(pedro);
        	tx.commit();
        	
        	
        }
        catch (Exception e) 
        {    if (tx!=null) tx.rollback(); e.printStackTrace(); }
        finally

        { session.close(); }
	}

	public Boolean EliminarTwit(Session session,int id) {
		Boolean eliminado = false;
		try{
			Twitt twitt = (Twitt)session.get(Twitt.class,id);
			session.delete(twitt);
			eliminado = true;
		}catch(Exception ex){
			System.out.print("Twitt No eliminado");
		}
		return eliminado;
	}

	public Boolean UpdateConfiguracion (Session session, Persona persona) {
		Boolean actualizado = false;
		try{
			Persona per = (Persona)session.get(Configuracion.class,persona.getIdPersona());
			per.setConfiguracion(persona.getConfiguracion());
			session.update(per);
			actualizado = true;
		} catch(Exception ex){

		}
		return actualizado;
	}

	public SessionFactory CreateSessionFactory(){
		Configuration c=new Configuration();

        c.configure();
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
        return c.buildSessionFactory(sr);
	}
	
	public Session Connect(SessionFactory sf){
		return this.sf.openSession();
	}
	
	
	public Object GetObject(SessionFactory sf, Class objeto, Integer id ){
		Session session = Connect(sf);
		Transaction tx = null;
		
		try{
        	tx = session.beginTransaction();
        	Object obj = session.get(objeto.getClass(),id);
        	tx.commit();
        	return obj;
        	
        }
        catch (Exception e) 
        {    if (tx!=null) tx.rollback(); e.printStackTrace(); }
        finally

        { session.close(); }
		
		return null;
	}
	
	
	
	public Persona GetObjectPersona(Integer id){
		return (Persona)GetObject(this.sf,Persona.class,id);
	}
	
	public Grupo GetObjectGrupo(Integer id){
		return (Grupo)GetObject(this.sf,Grupo.class,id);
	}
	
	public Pais GetObjetPais(Integer id){
		return (Pais)GetObject(this.sf,Pais.class,id);
	}
	
	public void CreateObject(SessionFactory sf,Object obj){
		Session session = Connect(sf);
		Transaction tx=null;
		
		try{
        	tx = session.beginTransaction();
        	session.save(obj);
        	tx.commit();
        	
        	
        }
        catch (Exception e) 
        {    if (tx!=null) tx.rollback(); e.printStackTrace(); }
        finally

        { session.close(); }
	}
	
	
	
	public void Menu(){
		System.out.print("-------- PIULADES -----------");
		System.out.print("-------- PIULADES -----------");
		System.out.print("-------- PIULADES -----------");
		System.out.print("-------- PIULADES -----------");
	}
}

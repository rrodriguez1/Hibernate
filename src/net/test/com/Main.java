/**
 * 
 */
package net.test.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public Boolean UpdatePersoma (Persona persona) {
		Session session = Connect(this.sf);
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
	
	
	// crear objeto en la base de datps
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
	
	
	/// Creates 
	public void CrearPais() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nom, iso;
		System.out.print("Nom del pais");
		nom = br.readLine();
		System.out.print("Codi ISO");
		iso = br.readLine();
		
		Pais pais = new Pais(nom,iso);
		CreateObject(this.sf,pais);
		
		
	}
	
	public void CrearGrupo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nom;
		System.out.print("Nom del Grup");
		nom = br.readLine();
		
		Grupo grupo = new Grupo(nom);
		CreateObject(this.sf,grupo);
	}
	
	public void CrearPersona() throws IOException , ParseException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Configuracion baseConfig = new Configuracion("","#ffffff",false);
		String nom, cognom,direccio,pais;
		Date naixement;
		
		System.out.print("Nom");
		nom = br.readLine();
		System.out.print("Cognom");
		cognom = br.readLine();
		System.out.print("Direccio");
		direccio = br.readLine();
		System.out.print("Data de naixement en format dd/MM/yyyy");
		naixement = sdf.parse(br.readLine());
		System.out.print("Pais(Codi ISO)");
		pais = br.readLine();
		
		Persona persona= new Persona(nom, cognom,direccio, naixement,pais);
		
		persona.Configuracion("", "#fffff", false);
		
		CreateObject(this.sf,persona);
		
	}
	
	public void MenuPersona(Persona persona) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("---- PIULADES - Usuari ------");
		System.out.print("---- PIULADES - Usuari ------");
		System.out.print("---- PIULADES - Usuari ------");
		System.out.print("---- PIULADES - Usuari ------");

		Boolean exit = false;
		int menuOption;
		while(!exit)
		{
			System.out.print("[1]Twitt [2]Eliminar un Twitt [3]Visualitzar/Modificar configuracio [4]Afegir a grup [5]Twitts [0]Exit ");
			menuOption = Integer.parseInt(br.readLine());
			switch(menuOption)
			{
				case 1:
					Twitt(persona);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 0:
					exit=true;
					break;
				default:
					break;
			}
		}
	}
	
	
	
	
	
	
	public void Twitt(Persona p) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Missatge:");
		p.Twitt(br.readLine());
		
	}

	///clear console
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   }  
	
	
	
	public void Menu() throws NumberFormatException, IOException , ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("-------- PIULADES -----------");
		System.out.print("-------- PIULADES -----------");
		System.out.print("-------- PIULADES -----------");
		System.out.print("-------- PIULADES -----------");
		Boolean exit = false;
		int menuOption , personaId;
		while(!exit)
		{
			System.out.print("[1]Crear Pais [2]Crear Grupo [3]Crear persona [4]Menu Persona [5]Listados [0]Exit ");
			menuOption = Integer.parseInt(br.readLine());
			switch(menuOption)
			{
				case 1:
					CrearPais();
					break;
				case 2:
					CrearGrupo();
					break;
				case 3:
					CrearPersona();
					break;
				case 4:
					System.out.print("Id de la persona a modificar");
					personaId = Integer.parseInt(br.readLine());
					MenuPersona(GetObjectPersona(personaId));
					break;
				case 5:
					break;
				case 0:
					exit=true;
					break;
				default:
					break;
			}
			clearScreen();
		}
		
	}
}

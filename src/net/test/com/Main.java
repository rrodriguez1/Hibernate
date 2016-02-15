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
	
	public static SessionFactory sf;
	
	public static void main(String[] args) throws ParseException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*
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
        */
		sf =CreateSessionFactory();
		Menu();
	}

	public static Boolean EliminarPersona(Persona persona) {
		Session session = Connect(sf);
		Transaction tx = null;
		Boolean eliminado = false;
		try{
        	tx = session.beginTransaction();
			session.delete(persona);
			tx.commit();
			eliminado = true;
		}catch(Exception ex){
			System.out.print("Twitt No eliminado" + ex.toString());
		}
		return eliminado;
	}

	public static Boolean UpdatePersona (Persona persona) {
		Session session = Connect(sf);
		Transaction tx = null;
		Boolean actualizado = false;
		try{
        	tx = session.beginTransaction();
			session.update(persona);
			actualizado = true;
			tx.commit();
		} catch(Exception ex){

		}
		return actualizado;
	}

	
	public static SessionFactory CreateSessionFactory(){
		Configuration c=new Configuration();

        c.configure();
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
        return c.buildSessionFactory(sr);
	}
	
	public static Session Connect(SessionFactory sf){
		return sf.openSession();
	}
	
	
	public static Object GetObject(SessionFactory sf, java.lang.Class clase, Integer id ){
		Session session = Connect(sf);
		Transaction tx = null;
		
		try{
        	tx = session.beginTransaction();
        	Object obj = session.get(clase,id);
        	tx.commit();
        	return obj;
        	
        }
        catch (Exception e) 
        {    if (tx!=null) tx.rollback(); e.printStackTrace(); }
        finally

        { session.close(); }
		
		return null;
	}
	
	
	
	
	
	public static Persona GetObjectPersona(Integer id){
		return (Persona)GetObject(sf,Persona.class,id);
	}
	
	public static Grupo GetObjectGrupo(Integer id){
		return (Grupo)GetObject(sf,Grupo.class,id);
	}
	
	public static Pais GetObjetPais(Integer id){
		return (Pais)GetObject(sf,Pais.class,id);
	}
	
	
	// crear objeto en la base de datps
	public static void CreateObject(SessionFactory sf,Object obj){
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
	public static void CrearPais() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nom, iso;
		System.out.print("Nom del pais");
		nom = br.readLine();
		System.out.print("Codi ISO");
		iso = br.readLine();
		
		Pais pais = new Pais(nom,iso);
		CreateObject(sf,pais);
		
		
	}
	
	public static void CrearGrupo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nom;
		System.out.print("Nom del Grup");
		nom = br.readLine();
		
		Grupo grupo = new Grupo(nom);
		CreateObject(sf,grupo);
	}
	
	public static void CrearPersona() throws IOException , ParseException
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
		
		CreateObject(sf,persona);
		
	}
	
	public static void MenuPersona(Persona persona) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("---- PIULADES - Usuari ------\n");
		System.out.println("---- PIULADES - Usuari ------\n");
		System.out.println("---- PIULADES - Usuari ------\n");
		System.out.println("---- PIULADES - Usuari ------\n");

		Boolean exit = false;
		int menuOption;
		int idGrup;
		while(!exit)
		{
			System.out.println("[1]Twitt [2]Eliminar Persona [3]Visualitzar/Modificar configuracio [4]Afegir a grup [5]Twitts [0]Exit ");
			menuOption = Integer.parseInt(br.readLine());
			switch(menuOption)
			{
				case 1:
					Twitt(persona);
					break;
				case 2:
					EliminarPersona(persona);
					exit = true;
					break;
				case 3:
					break;
				case 4:
					System.out.println("Id del grup");
					idGrup = Integer.parseInt(br.readLine());
					AfegirGrup(persona,idGrup);
					break;
				case 5:
					System.out.println(persona.ShowAllTwitts());
					break;
				case 0:
					exit=true;
					break;
				default:
					break;
			}
		}
	}
	
	
	
	
	
	
	private static void AfegirGrup(Persona persona, int idGrup) {
		 Grupo grup = GetObjectGrupo(idGrup);
		 persona.addGrupo(grup);
		 UpdatePersona(persona);
		
	}

	public static void Twitt(Persona p) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Missatge:");
		String missatge = br.readLine();
		p.Twitt(missatge);
		UpdatePersona(p);
		
	}
	
	

	///clear console
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   }  
	
	
	
	public static void Menu() throws NumberFormatException, IOException , ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-------- PIULADES -----------");
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
					Persona persona = GetObjectPersona(personaId);
					if(persona != null)MenuPersona(persona);
					else
						System.out.print("Usuari no trobat\n");
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

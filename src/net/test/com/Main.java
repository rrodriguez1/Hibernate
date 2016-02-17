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
import java.util.List;

import org.hibernate.Query;
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
		
		Persona persona= new Persona(nom, cognom,direccio, naixement,CercaPaisPerISO(pais));
		
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
					EditarConfiguracio(persona);
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
	
	
	
	
	
	
	private static void EliminarPais(int paisId) {
		Pais pais = (Pais)GetObject(sf,Pais.class,paisId);
		Session session = Connect(sf);
		Transaction tx = null;
		Boolean eliminado = false;
		try{
        	tx = session.beginTransaction();
			session.delete(pais);
			tx.commit();
		}catch(Exception ex){
			System.out.print("Twitt No eliminado" + ex.toString());
		}
		
	}

	private static void EditarConfiguracio(Persona persona) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(persona.getConfiguracion().toString());
		System.out.println("Vols cambiar la configuració? S/N");
		String resposta = br.readLine();
		Configuracion config;
		if(resposta.toLowerCase().equals("s"))
		{
			config = CreaNovaConfiguracio(persona);
			persona.setConfiguracion(config);
			UpdatePersona(persona);
		}
			
		
	}

	private static Configuracion CreaNovaConfiguracio(Persona persona) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String estado, fondo , privadoString;
		Boolean privado;
		System.out.println("Estado");
		estado = br.readLine();
		System.out.println("Color fondo");
		fondo = br.readLine();
		System.out.println("Privado s/n");
		privadoString = br.readLine();
		
		if(privadoString.toLowerCase().equals("s"))
			privado=true;
		else if(privadoString.toLowerCase().equals("n"))
			privado = false;
		else
			privado = persona.getConfiguracion().getPrivado();
		
		return new Configuracion(persona.getIdPersona(),estado,fondo,privado);
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
		int menuOption , personaId, idPais;
		while(!exit)
		{
			System.out.println("[1]Crear Pais [2]Crear Grupo [3]Crear persona [4]Menu Persona [5]Listados [6]EliminarPais [0]Exit ");
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
					MostrarListados();
					break;
				case 6:
					System.out.print("Id dl pais a eliminar");
					idPais = Integer.parseInt(br.readLine());
					idPais = Integer.parseInt(br.readLine());
					EliminarPais(idPais);
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

	private static void MostrarListados() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-------- Llistats -----------");
		Boolean exit = false;
		int menuOption , personaId;
		while(!exit)
		{
			System.out.println("[1]Paisos [2]Grups [3]Persones [0]Exit ");
			menuOption = Integer.parseInt(br.readLine());
			switch(menuOption)
			{
				case 1:
					System.out.println(MostrarPaisos());
					break;
				case 2:
					System.out.println(MostrarGrups());
					break;
				case 3:
					System.out.println(MostrarPersones());
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

	private static String MostrarPersones() {
		// TODO Auto-generated method stub
		return MostrarElements("from Persona");
	}

	private static String MostrarGrups() {
		// TODO Auto-generated method stub
		return MostrarElements("from Grupo");
	}

	private static String MostrarPaisos() {
		// TODO Auto-generated method stub
		return MostrarElements("from Pais");
	}
	
	private static Pais CercaPaisPerISO(String iso){
		Session session = Connect(sf);
		String hql = "FROM Pais P WHERE P.paIso = '"+iso+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		return (Pais)results.get(0);
	}

	private static String MostrarElements(String string) {
		Session session = Connect(sf);
		Query query = session.createQuery(string);
		List<Object> list = query.list();
		
		String resultat ="";
		
		for(Object obj : list)
			resultat += obj.toString();
		return resultat;
	}
}

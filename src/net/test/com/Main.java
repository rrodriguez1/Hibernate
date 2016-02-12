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
 * @author Pedro
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
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

}

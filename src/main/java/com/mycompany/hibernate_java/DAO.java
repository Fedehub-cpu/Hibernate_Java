package com.mycompany.hibernate_java;
import java.util.ArrayList;
import models.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DAO {
    
    private SessionFactory sessionFactory;
    
     public void connect(){
        try{
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            System.out.println("Conexión establecida con éxito.");
        }catch(Exception ex){
            System.out.println("Error al crear la conexión.");
            System.out.println(ex);
        }
    }  

     public void save (Alumno a){
    Session s = sessionFactory.openSession();
    Transaction t = s.beginTransaction();
    s.save(a);
    t.commit();
    s.close();
    }
    
     
     public void delete (Alumno a){
    Session s = sessionFactory.openSession();
    Transaction t = s.beginTransaction();
    s.delete(t);
    t.commit();
    s.close();
    }
     
    public void imprimir (){
    Session s = sessionFactory.openSession();
    Query q = s.createQuery("FROM Alumno");
    ArrayList<Alumno> resultado = (ArrayList<Alumno>) q.list();
    System.out.println("Alumnos de la clase: ");
    for (Alumno a: resultado){
    
    System.out.println("["+a.getId()+"]"
    +" "+ a.getNombre()
    +" " + a.getApellidos());
    }
    s.close();
    }
     
     
    public Alumno leer (Long id){
    Session s = sessionFactory.openSession();
    Transaction t = s.beginTransaction();
    Alumno a = s.get(Alumno.class, id);
    s.close();
    return(a);

  
    }


  public void update(Alumno a){
    Session s = sessionFactory.openSession();
    Transaction t = s.beginTransaction(); 
    s.update(a);
    t.commit();
    s.close();
    }
}

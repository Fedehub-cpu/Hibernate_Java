package com.mycompany.hibernate_java;

import models.Alumno;





public class Main {

 
    public static void main(String[] args) {
        
        DAO dao= new DAO(); 
        dao.connect();
        

       Alumno a = new Alumno();
      a.setNombre("Joaquín");
      a.setApellidos("Guillén");
      a.setEdad(22);
      a.setAsignaturas(3);
      a.setCurso("Segundo A");
      dao.save(a);
      dao.imprimir();
      dao.delete(a);

           
    }
    
}

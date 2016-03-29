/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.itwall.impl.PersonaServiceImpl;
import com.itwall.service.PersonaService;
import java.util.ArrayList;

/**
 *
 * @autor: oscar lemoine
 * Descripcion: metodo principal para realizar creacion de objetos necesarios
 *              y llamada a los metodos utilizados
 *              se utiliza interface "PersonaServiceImpl", cuyos metodos son definidos en la clase PersonaDTO
 */
public class AppItwall {
  public static void main(String[] args){
    
    PersonaService servicio = new PersonaServiceImpl();
    PersonaDTO persona = new PersonaDTO();
    persona.setId_persona(1); //Busca el registro con idpersona = 1
    persona = servicio.findById(persona);//Utiliza metodo para buscar un registro por su ID
    //Luego imprime los datos por consola
    System.out.println("Nombre: "+persona.getPnombre()+", direccion: "+persona.getpDireccion()+", telefono: "+persona.getpNumTelefono()+", email: "+persona.getpImail());
    
   
    //PersonaDTO persona2 = new PersonaDTO();
    ArrayList<PersonaDTO> lista = new ArrayList();
    lista = servicio.findAll();
     for(int i = 0;i<lista.size();i++){
            System.out.println("ID: "+lista.get(i).getId_persona()+", Nombre :"+lista.get(i).getPnombre()+", Dir: "+lista.get(i).getpDireccion()+", Telefono: "+lista.get(i).getpNumTelefono());
}
   
  }
    
}

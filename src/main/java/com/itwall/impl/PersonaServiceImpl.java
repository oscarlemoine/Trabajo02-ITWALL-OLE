
package com.itwall.impl;

import com.itwall.service.PersonaService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.ConnMySql;
import main.PersonaDTO;
import noUtilizado.JdbcSelectDemo;
/**
 * @author oscar lemoine
 */
public class PersonaServiceImpl implements PersonaService{
    
public PersonaDTO findById(PersonaDTO per)
        {
            try{
                Connection conn = ConnMySql.obtener();
                String query    = "SELECT id_persona, p_nombre, direccion, num_telefono , email FROM tb_persona_proyecto WHERE id_persona = "+ per.getId_persona();
                Statement st    = conn.createStatement();
                ResultSet rs    = st.executeQuery(query);
                while(rs.next()){
                    per.setPnombre(rs.getString("p_nombre"));
                    per.setpDireccion(rs.getString("direccion"));
                    per.setpNumTelefono(rs.getInt("num_telefono"));
                    per.setpImail(rs.getString("email"));
                }
                ConnMySql.cerrar();

            }catch(SQLException ex){ex.printStackTrace() ;}
            catch(ClassNotFoundException ex){
                Logger.getLogger(JdbcSelectDemo.class.getName()).log(Level.SEVERE,null,ex);}
            
         return per;
        }  
    
    public ArrayList findAll(){
        int i=0;
        ArrayList<PersonaDTO> lista = new ArrayList();
                
            try{
                Connection conn = ConnMySql.obtener();
                String query    = "SELECT id_persona, p_nombre, direccion, num_telefono , email FROM tb_persona_proyecto";
                Statement st    = conn.createStatement();
                ResultSet rs    = st.executeQuery(query);

                while(rs.next()){
                    PersonaDTO per = new PersonaDTO();
                    per.setId_persona(rs.getInt("id_persona"));
                    per.setPnombre(rs.getString("p_nombre"));
                    per.setpDireccion(rs.getString("direccion"));
                    per.setpNumTelefono(rs.getInt("num_telefono"));
                    per.setpImail(rs.getString("email"));
                    lista.add(per);
                }
                ConnMySql.cerrar();

            }catch(SQLException ex){ex.printStackTrace() ;}
            catch(ClassNotFoundException ex){
                Logger.getLogger(JdbcSelectDemo.class.getName()).log(Level.SEVERE,null,ex);}
            
    
        return lista;
    }
}

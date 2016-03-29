package noUtilizado;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.ConnMySql;

/**
 * Created by JAVA on 23-03-2016.
 */
public class JdbcSelectDemo {
    public static void main(String[] args) {

        try{
            int idpersona = 1;
            Connection conn = ConnMySql.obtener();
            String query    = "SELECT id_persona, p_nombre, direccion, num_telefono , email FROM tb_persona_proyecto";// WHERE id_persona = "+ idpersona;
            Statement st    = conn.createStatement();
            ResultSet rs    = st.executeQuery(query);

            while(rs.next()){
                int id_persona   = rs.getInt(1);
                String p_nombre  = rs.getString("p_nombre");
                String direccion = rs.getString("direccion");
                Integer num_telefono = rs.getInt("num_telefono");

                System.out.format(" Registro = %s, %s, %s, %s\n", id_persona, p_nombre, direccion, num_telefono);
            }
            ConnMySql.cerrar();

        }catch(SQLException ex){ex.printStackTrace() ;}
        catch(ClassNotFoundException ex){
            Logger.getLogger(JdbcSelectDemo.class.getName()).log(Level.SEVERE,null,ex);}
    }
}

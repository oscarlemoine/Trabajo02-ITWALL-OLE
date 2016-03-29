package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnMySql {

    static String driver;
    static String url;
    static String user;
    static String password;

    static {
        try {
            Properties propiedades = new Properties();
            propiedades.load(ConnMySql.class.getResourceAsStream("/data.properties"));

            driver = propiedades.getProperty("driver");
            url = propiedades.getProperty("url");
            user = propiedades.getProperty("user");
            password = propiedades.getProperty("password");

        } catch (IOException ex) {
            Logger.getLogger(ConnMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {

        if (cnx == null) {
            try {
                Class.forName(driver);
                cnx = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

}
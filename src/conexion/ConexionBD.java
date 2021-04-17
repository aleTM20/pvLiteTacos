package conexion;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */

public class ConexionBD {
    String base = "taquitos";      //Nombre de La Base De Datos
    String usuario = "root";        //Usuario Para Acceder Al Servidor Mysql
    String password = "";  
    String url = "jdbc:mysql://127.0.0.1:3306/" + base;
    Connection conect = null;
  

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection(url, usuario, password); 
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
             System.exit(0);
        }
        return conect;
//    
//     public Connection Desconectar() {
//        try {
//            conect.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
//        }
//        return conect;
//    }   
}}

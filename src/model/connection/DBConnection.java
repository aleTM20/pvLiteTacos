package model.connection;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */
public class DBConnection {

    private String dataBase = "taquitos";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://127.0.0.1:3306/" + dataBase;
    private Connection connection = null;

    public Connection openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
            System.exit(0);
        }
        return connection;
    
    }

    public Connection closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return connection;
    }
}

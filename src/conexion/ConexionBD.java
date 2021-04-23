package conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */
public class ConexionBD {

    private final String PATH = "C:\\TaquitosToluca\\settingsIpAddress.txt";
    String base = "taquitos";      //Nombre de La Base De Datos
    String usuario = "root";        //Usuario Para Acceder Al Servidor Mysql
    String password = "";
    String url = "";
    Connection conect = null;

    public ConexionBD() {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            file = new File(PATH);
            if (file.exists()) {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                // Lectura del fichero
                String line;
                if ((line = br.readLine()) != null) {
                    this.url = "jdbc:mysql://" + line + ":3306/" + base;
                }

            } else {
                file.createNewFile();
                String ipAddress = "192.168.0.1";
                fichero = new FileWriter(file);
                pw = new PrintWriter(fichero);
                pw.println(ipAddress);
                fichero.close();
                this.url = "jdbc:mysql://" + ipAddress + ":3306/" + base;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
    }

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("conectando a: " + url);
            conect = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
            System.exit(0);
        }
        return conect;
    }

    public Connection Desconectar() {
        try {
            conect.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }
}

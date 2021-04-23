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
    String ipAddress = "192.168.0.1";
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
                int i = 1;
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    switch (i) {
                        case 1:
                            this.ipAddress = line;
                            break;
                        case 2:
                            this.usuario = line;
                            break;
                        case 3:
                            this.password = line;
                            break;
                        case 4:
                            this.base = line;
                            break;
                    }
                    i++;
                }
                this.url = "jdbc:mysql://" + this.ipAddress + ":3306/" + this.base;

            } else {
                file.createNewFile();
                fichero = new FileWriter(file);
                pw = new PrintWriter(fichero);
                pw.println(this.ipAddress);
                fichero.close();
                this.url = "jdbc:mysql://" + this.ipAddress + ":3306/" + base;
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
            //System.out.println("conectando a: " + this.url);
            conect = DriverManager.getConnection(this.url, this.usuario, this.password);
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

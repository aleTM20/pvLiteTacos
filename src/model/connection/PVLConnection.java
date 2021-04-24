/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pv_lite_team
 */
public class PVLConnection {
    private final String PATH = "C:\\TaquitosToluca\\settingsIpAddress.txt";
    String dataBase = "taquitos";      //Nombre de La Base De Datos
    String user = "root";        //Usuario Para Acceder Al Servidor Mysql
    String password = "";
    String ipAddress = "127.0.0.1";
    String url = "";
    java.sql.Connection conect = null;

    public PVLConnection() {
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
                            this.user = line;
                            break;
                        case 3:
                            this.password = line;
                            break;
                        case 4:
                            this.dataBase = line;
                            break;
                    }
                    i++;
                }
                this.url = "jdbc:mysql://" + this.ipAddress + ":3306/" + this.dataBase;

            } else {
                file.createNewFile();
                fichero = new FileWriter(file);
                pw = new PrintWriter(fichero);
                pw.println(this.ipAddress);
                pw.println(this.user);
                pw.println(this.password);
                pw.println(this.dataBase);
                fichero.close();
                this.url = "jdbc:mysql://" + this.ipAddress + ":3306/" + dataBase;
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println(e2.toString());
            }
        }
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("conectando a: " + this.url);
            conect = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
            System.exit(0);
        }
        return conect;
    }

    public Connection closeConnection() {
        try {
            conect.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }
    
}

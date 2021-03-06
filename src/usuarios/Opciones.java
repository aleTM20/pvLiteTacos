/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import conexion.ConexionBD;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import login.Login;
import principal.PrincipalAdministrador;
import principal.PrincipalMesero;

/**
 *
 * @author Rojeru San CL
 */
public class Opciones {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getUsuario());
            ps.setString(2, Encrypting.getMD5(uc.getPassword()));
            ps.setString(3, uc.getTipo());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Sentencias uc) {
        int rsu = 0;
        if (!uc.getPassword().equals("")) {
            String sql = Sentencias.ACTUALIZAR;
            try {
                ps = cn.prepareStatement(sql);
                ps.setString(1, uc.getUsuario());
                ps.setString(2, Encrypting.getMD5(uc.getPassword()));
                ps.setString(3, uc.getTipo());
                ps.setInt(4, uc.getId());
                rsu = ps.executeUpdate();
            } catch (SQLException ex) {
            }
            System.out.println(sql);
        }else{
            String sql = Sentencias.ACTUALIZARUSUARIO;
            try {
                ps = cn.prepareStatement(sql);
                ps.setString(1, uc.getUsuario());
                ps.setString(2, uc.getTipo());
                ps.setInt(3, uc.getId());
                rsu = ps.executeUpdate();
            } catch (SQLException ex) {
            }
            System.out.println(sql);
        }
        System.out.println(rsu);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Sentencias.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Usuarios.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM usuarios WHERE (idusuario LIKE'" + busca + "%' OR "
                    + "usuario LIKE'" + busca + "%' OR nombre LIKE'" + busca + "%' OR "
                    + "tipousuario LIKE'" + busca + "%') AND idusuario!=1 "
                    + "ORDER BY idusuario";
        }
        String datos[] = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idusuario");              
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("usuario");
                datos[3] = rs.getString("tipousuario");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean verificaUsuario(String usuario) {
        boolean existe = false;
        String user = "";
        try {
            String sql = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                user = rs.getString(2);
            }

            if (user.equals(usuario)) {
                existe = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    } 
}
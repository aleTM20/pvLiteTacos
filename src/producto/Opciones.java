/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rojeru San CL
 */
public class Opciones {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    
      public static void registrarInventario(int id,int cantidad) {
    
        String sql ="INSERT INTO inventario values("+id+","+cantidad+");";
          System.out.println(sql);
        
        try {
        ps = cn.prepareStatement(sql);
         ps.executeUpdate();
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static int registrar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getTipo());
            ps.setDouble(4, uc.getPrecio());
            ps.setString(5, uc.getStock());
            ps.setString(6, uc.getId());
            ps.setInt(7, uc.getIdInsumo());
            ps.setFloat(8, uc.getCantidadInsumo());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getTipo());
            ps.setDouble(4, uc.getPrecio());
            ps.setString(5, uc.getStock());
            ps.setString(6, uc.getId());
            System.out.println(uc.getNombre());
            System.out.println(uc.getDescripcion());
            System.out.println(uc.getTipo());
            System.out.println(uc.getPrecio());
            System.out.println(uc.getStock());
            System.out.println(uc.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int actualizarStock(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.ACTUALIZAR_STOCK;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getStock());
            ps.setString(2, uc.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int eliminar(String id) {
        int rsu = 0;
        String sql = Sentencias.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int eliminarTodo() {
        int rsu = 0;
        String sql = Sentencias.ELIMINAR_TODO;

        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
            rsu++;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

//"select idventa, producto.nombre, cantidad, total, fecha from ventas join producto on ventas.id_producto=producto.idproducto WHERE
    

    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) producto.Productos.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM producto WHERE (idproducto LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%' OR descripcion LIKE'" + busca + "%' OR "
                    + "tipoproducto LIKE'" + busca + "%' OR precio LIKE'" + busca + "%' OR "
                    + "idproducto LIKE'" + busca + "%')"
                    + "GROUP BY nombre, descripcion "
                    + "ORDER BY idproducto";
        }
        Object datos[] = new Object[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
                datos[4] = rs.getString("precio");
                if(rs.getString("tipoproducto").equals("COMIDA")){
                datos[5] = "-----";
                }else{
                datos[5] = enInventario(rs.getString("idproducto"));
                }
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("error en llenar productos "+ex.getMessage());
        }
    }
        public static int enInventario(String id) {
    
        String SQL = "select * from inventario where idProducto="+id;

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
               return rs.getInt("cantidad");
            }
                      
        } catch (SQLException ex) {
            System.out.println("error en optener de inventarioo "+ex.getMessage());
        }
        return 0;
    }
    
    public static String extraerID() {
        String c = "";
        String SQL = "SELECT MAX(idproducto) FROM producto";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
     public ArrayList obtenerInsumos(){
         
        ArrayList lista = new ArrayList();
        String SQL = "SELECT insumo FROM insumos ORDER BY insumo ASC";
        try {
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                String insumo = rs.getString("insumo");
                
                    lista.add(insumo); 
            }
        } catch (SQLException ex) {
            System.out.println("El error es: "+ex);
        }
         
        return lista;
    }
     public static int obtenerIdInsumo(String ins){
         
        int lista = 0;
        String SQL = "SELECT idInsumo FROM insumos where insumo='"+ ins+"'";
        try {
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                lista = rs.getInt("idInsumo");
                
                    
            }
        } catch (SQLException ex) {
            System.out.println("El error es: "+ex);
        }
         
        return lista;
    }
     public ArrayList obtenerUnidadesMedida(){
         
        ArrayList lista = new ArrayList();
        String SQL = "SELECT unidad_medida FROM insumos ORDER BY insumo ASC";
        try {
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                String insumo = rs.getString("unidad_medida");
                
                    lista.add(insumo); 
            }
        } catch (SQLException ex) {
            System.out.println("El error es: "+ex);
        }
         
        return lista;
    }
    
    public static void iniciarTransaccion(){
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void finalizarTransaccion(){
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void commit(){
        try {
            cn.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cancelarTransaccion(){
        try {
            cn.setAutoCommit(false);
            cn.rollback();
            cn.setAutoCommit(true);
            
        } catch (SQLException ex) {
            System.out.println("Entro excepcion rollback");
            
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

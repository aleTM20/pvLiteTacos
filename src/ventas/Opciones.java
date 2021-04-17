/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rojeru San CL
 */
public class Opciones {
static DecimalFormat df= new DecimalFormat("#.00");
    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getId_venta());
            ps.setString(2, uc.getId_producto());
            ps.setDouble(3, uc.getCantidad());
            ps.setDouble(4, uc.getTotal());
            ps.setString(5, uc.getFecha());
            ps.setString(6, uc.getUsuario());
            ps.setInt(7, uc.getMesa());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    public static int registrar_venta_proceso(String NoTicket,String NoVenta, float total, int NoMesa, String status) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR_VENTAS_PROCESO;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, NoTicket);
            ps.setString(2, NoVenta);
            ps.setFloat(3, total);
            ps.setInt(4, NoMesa);
            ps.setString(5, status);
           
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    public static int registrarTicket(String idTicket, String idVenta, String fecha, double total, String usuario, String status) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR_TICKET;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, idTicket);
            ps.setString(2, idVenta);
            ps.setString(3, fecha);
            ps.setDouble(4, total);
            ps.setString(5, usuario);
            ps.setString(6, status);
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
            ps.setInt(1, uc.getCantidad());
            ps.setDouble(2, uc.getTotal());
            ps.setString(3, uc.getFecha());
            ps.setString(4, uc.getId_producto());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    public static int eliminarVentaProceso(String idTicket) {
        int rsu = 0;
        String sql = "DELETE FROM ventasProceso WHERE idTicket='"+idTicket+"'";
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("hubo un error en borrar la tabla procesos");
        }
        System.out.println(sql);
        return rsu;
    }
//    public static int actualizarStatus(Sentencias uc) {
//        int rsu = 0;
//        String sql = "UPDATE ventasProceso SET status='Cerrada' WHERE ";
//        try {
//            ps = cn.prepareStatement(sql);
//            ps.setInt(1, uc.getCantidad());
//            ps.setDouble(2, uc.getTotal());
//            ps.setString(3, uc.getFecha());
//            ps.setString(4, uc.getId_producto());
//            rsu = ps.executeUpdate();
//        } catch (SQLException ex) {
//        }
//        System.out.println(sql);
//        return rsu;
//    }
    public static int actualizarStatusTicket(String idVenta) {
        int rsu = 0;
        String sql = "UPDATE ticket SET status='CERRADA' WHERE idTicket='"+idVenta+"'";
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
       
        System.out.println(sql);
        return rsu;
    }
    public static int actualizarStatusVentas(String numTicket) {
        int rsu = 0;
       
        String sql2 = "UPDATE ventasProceso SET status='CERRADA' WHERE idTicket='"+numTicket+"'";
        try {
            ps = cn.prepareStatement(sql2);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql2);
        return rsu;
    }

    public static void actualizarExistencias(float existencia,String id) {
      
//        System.out.println("UPDATE insumos set existencias="+existencia+" ,fechaCaducidad='"+fecha+"' where idInsumo="+id);
//        String sql = "UPDATE insumos set existencias=0 "
//                                    + ",fechaCaducidad='2018-09-02'"
//                                    + " where idInsumo=1";
      try {  
          String sql = "UPDATE insumos set existencias="+existencia+" where idInsumo="+id;
          System.out.println(sql);
                PreparedStatement pst=cn.prepareStatement(sql);
            pst.executeUpdate();
        
//            PreparedStatement pst=cn.prepareStatement(sql);
//            pst.setFloat(1,existencia);
//            pst.setString(2, fecha);
//            pst.setInt(3, Integer.parseInt(id));
//           
//             pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en actualizar "+ex.getMessage());
        }
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

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.Productos.tabla.getModel();

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
                    + "idproducto LIKE'" + busca + "%') "
                    + "GROUP BY nombre, descripcion "
                    + "ORDER BY idproducto";
            System.out.println(sql);
        }
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
                datos[4] = rs.getString("precio");
                datos[5] = rs.getString("stock");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void listar3(String idVenta) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.Ventas.tblMesas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = Sentencias.LISTAR3;
       
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("NoMesa");
                datos[1] = rs.getString("total");
                datos[2] = "ABIERTA";
                datos[3] = rs.getString("NoVenta");
          
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


  public static float  insumoExistencia(String busca) {
      
        String sql = "";
        sql = "select * from insumos where idInsumo="+busca+";";
       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
        return rs.getFloat("existencias");
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    public static void listarVentas(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.ListaVentas.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if(busca.equals("")){
        sql = "SELECT * FROM ticket where status=1;";}
        else{
        sql="SELECT * FROM ticket where status=1 and fecha='"+busca+"';";
        }
       Object datos[] = new Object[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("mesa");
                datos[1] = rs.getFloat("total");
                datos[2] = rs.getString("fecha");
                 modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void listarDetalles(int idTicket) {
//        //se actualiza la tabla de detalles de una venta
//        DefaultTableModel modelo = (DefaultTableModel) Detalles.tabla.getModel();
//        while (modelo.getRowCount() > 0) {
//            modelo.removeRow(0);
//        }
//        String sql = "";
//        
//            sql = "select producto.nombre as nombre, cantidad, ventas.total as total,from ticket"
//                    + " join ventas on ticket.idventa=ventas.idventa join producto on ventas.id_producto=producto.idproducto"
//                    + " where idTicket="+idTicket+"";
//        
//        String datos[] = new String[3];
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            
//            while (rs.next()) {
//                
//                datos[0] = rs.getString("nombre");
//                datos[1] = rs.getString("cantidad");
//                datos[2] = rs.getString("total");
//                
//                modelo.addRow(datos);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//    }

    public static float existencias(String idInsumo,int d) {
        
        String SQL = "select * from insumos where idinsumo=" + idInsumo + "";
        System.out.println(SQL);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                float existencias = rs.getFloat("existencias");
               return existencias;
            }

        } catch (SQLException ex) {
            System.out.println("no existe"+ex.getMessage());
        }
        return 0;
    }

    public static ArrayList idInsumos(String idProducto) {
        ArrayList c = new ArrayList();
        String SQL = "select producto.idInsumo, cantidadInsumo, existencias from producto inner"
                + " join insumos on producto.idInsumo=insumos.idInsumo where idproducto='" + idProducto + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                String existencias = rs.getString("idInsumo");
                c.add(existencias);
            }

        } catch (SQLException ex) {
            Logger.getLogger(insumo.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static ArrayList cantidadInsumo(String idProducto) {
        ArrayList c = new ArrayList();
        String SQL = "select cantidadInsumo, existencias from producto inner"
                + " join insumos on producto.idInsumo=insumos.idInsumo where idproducto='" + idProducto + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                String idInsumo = rs.getString("cantidadInsumo");
                c.add(idInsumo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(insumo.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    public static String idTicket(String idVenta) {
        String c = "";
        String SQL = "select idTicket from ticket where idventa='"+idVenta + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString("idTicket");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(insumo.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    public static String idVenta(String idTicket) {
        String c = "";
        String SQL = "select idVenta from ticket where idTicket='"+idTicket + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString("idVenta");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(insumo.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void listarEntradas(String fecha) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.ModalCorteDia.ListaEntradas.getModel();

String sql = "select mesa,cantidad,nombre,ventas.total as total from "
        + "ticket inner join ventas on ventas.idTicket=ticket.idTicket "
        + "INNER JOIN producto on producto.idproducto=ventas.id_producto where fecha='"+fecha+"' and STATUS=1;";
        String datos[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("mesa");
                datos[1] = (rs.getString("nombre") + " -> " + rs.getString("cantidad"));
                datos[2] = rs.getString("total");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        corteEntradas();
    }

    public static void corteEntradas() {
        int filas = ventas.ModalCorteDia.ListaEntradas.getRowCount();
        double totalE = 0.0;
        for (int i = 0; i < filas; i++) {
            totalE = totalE + Double.parseDouble(ventas.ModalCorteDia.ListaEntradas.getValueAt(i, 2).toString());
        }
        ventas.ModalCorteDia.lblE.setText(df.format(totalE)+"");
    }

    public static void listarSalidas(String fecha) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.ModalCorteDia.ListaSalidas.getModel();

        String sql = "SELECT * FROM gastos WHERE fecha_gasto = '" + fecha + "'";
        String datos[] = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("descripcion");
                datos[1] = rs.getString("gastado");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        corteSalidas();
    }

    public static void corteSalidas() {
        int filas = ventas.ModalCorteDia.ListaSalidas.getRowCount();
        double totalE = 0.0;
        for (int i = 0; i < filas; i++) {
            totalE = totalE + Double.parseDouble(ventas.ModalCorteDia.ListaSalidas.getValueAt(i, 1).toString());
        }
        ventas.ModalCorteDia.lblS.setText(df.format(totalE)+"");
    }

    public static void corteTotal() {
        double entradas = Double.parseDouble(ventas.ModalCorteDia.lblE.getText());
        double salidas = Double.parseDouble(ventas.ModalCorteDia.lblS.getText());
        ventas.ModalCorteDia.total.setText(df.format(entradas - salidas)+"");
    }

    public static void calcular() {
        String pre;
        String can;
        double total = 0;
        double precio;
        int cantidad;
        double imp = 0.0;

        for (int i = 0; i < ventas.Ventas.tblDescripcion.getRowCount(); i++) {
            pre = ventas.Ventas.tblDescripcion.getValueAt(i, 4).toString();
            can = ventas.Ventas.tblDescripcion.getValueAt(i, 3).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            total = total + imp;
            ventas.Ventas.tblDescripcion.setValueAt(Math.rint(imp * 100) / 100, i, 5);

        }
        ventas.Ventas.lblTotal.setText("" + Math.rint(total * 100) / 100);
    }

    public static void corteCaja() {
        int filas = ventas.ListaVentas.tabla.getRowCount();
        double totalE = 0.0;
        for (int i = 0; i < filas; i++) {
            totalE = totalE + Double.parseDouble(ventas.ListaVentas.tabla.getValueAt(i,1).toString());
        }
        ventas.ListaVentas.lblTotal1.setText(String.valueOf(totalE));
    }

    public static boolean existe(String mesaventas) {
        boolean op = false;
        int filasMesa = ventas.Ventas.tblMesas.getRowCount();
        for (int i = 0; i < filasMesa; i++) {
            String mesa = ventas.Ventas.tblMesas.getValueAt(i, 0).toString();
            if (mesaventas.equals(mesa)) {
                op = true;
            }
        }
        
        return op;
    }
    public static int obtenerFila(String mesaventas) {
      int op = 0;
         int filasMesa = ventas.Ventas.tblMesas.getRowCount();
        for (int i = 0; i < filasMesa; i++) {
            String mesa = ventas.Ventas.tblMesas.getValueAt(i, 0).toString();
            if (mesaventas.equals(mesa)) {
                op = i;
            }
        }
      return op;
    }

    public static void enviarMesa(String idVenta) {
        DefaultTableModel tabladet = (DefaultTableModel) ventas.Ventas.tblMesas.getModel();
        String[] dato = new String[4];
        float total = 0;
        int filasMesa = ventas.Ventas.tblMesas.getRowCount();
        int filasVentas = ventas.Ventas.tblDescripcion.getRowCount();
        if (filasMesa == 0) {
            for (int i = 0; i < filasVentas; i++) {
                dato[0] = ventas.Ventas.tblDescripcion.getValueAt(i, 6).toString();
                total += Float.parseFloat(ventas.Ventas.tblDescripcion.getValueAt(i, 5).toString());
                dato[1] = String.valueOf(total);
                
            }
            dato[2] = "Abierta";
            dato[3] = idVenta;
            tabladet.addRow(dato);

            ventas.Ventas.tblMesas.setModel(tabladet);
        } else if (filasMesa > 0) {
            String mesa = ventas.Ventas.tblDescripcion.getValueAt(0, 6).toString();
            if (existe(mesa)) {
                int fila = obtenerFila(mesa);
                
                float totalif = 0;
                    totalif = Float.parseFloat(ventas.Ventas.tblMesas.getValueAt(fila, 1).toString());
                    
                    for (int j = 0; j < filasVentas; j++) {
                        totalif += Float.parseFloat(ventas.Ventas.tblDescripcion.getValueAt(j, 5).toString());
                        
                    }
                    ventas.Ventas.tblMesas.setValueAt(totalif, fila, 1);
                
            } else {
                float totalelse = 0;
                for (int i = 0; i < filasVentas; i++) {
                    dato[0] = ventas.Ventas.tblDescripcion.getValueAt(i, 6).toString();
                    totalelse += Float.parseFloat(ventas.Ventas.tblDescripcion.getValueAt(i, 5).toString());
                    
                }
                dato[1] = String.valueOf(totalelse);
                dato[2] = "Abierta";
                dato[3] = idVenta;
                tabladet.addRow(dato);
                ventas.Ventas.tblMesas.setModel(tabladet);
            }
        }

//        String sql = "SELECT * FROM producto WHERE idproducto = '" + codigo+"'";
//        
//        String nombre = null;
//        String descripcion = null;
//        String precio = null;
//        String cant = String.valueOf(cantidad);
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                nombre = rs.getString("nombre");
//                descripcion = rs.getString("descripcion");
//                precio = rs.getString("precio");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        int c = 0;
//        int j = 0;
//
//        for (int i = 0; i < ventas.Ventas.tablaVentas.getRowCount(); i++) {
//            Object com = ventas.Ventas.tablaVentas.getValueAt(i, 0);
//            Object cant1 = ventas.Ventas.tablaVentas.getValueAt(i, 3);
//            if (codigo.equals(com)) {
//                j = i;
//                int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
//                ventas.Ventas.tablaVentas.setValueAt(String.valueOf(cantT), i, 3);
//                c++;
//                calcular();
//                ventas.Ventas.txtImporte.setText("");
//                ventas.Ventas.txtCambio.setText("");
//            }
//        }
//        if (c == 0) {
//
//            dato[0] = codigo;
//            dato[1] = nombre;
//            dato[2] = descripcion;
//            dato[3] = cant;
//            dato[4] = precio;
//
//            tabladet.addRow(dato);
//
//            ventas.Ventas.tablaVentas.setModel(tabladet);
//            calcular();
//
//            ventas.Ventas.txtImporte.setText("");
//            ventas.Ventas.txtCambio.setText("");
//        }
    }

    public static void enviar(String codigo, int cantidad, String NoMesa) {
        DefaultTableModel tabladet = (DefaultTableModel) ventas.Ventas.tblDescripcion.getModel();
        String[] dato = new String[7];
        int fila = ventas.Productos.tabla.getSelectedRow();

        String sql = "SELECT * FROM producto WHERE idproducto = '" + codigo + "'";
        
        String nombre = null;
        String descripcion = null;
        String precio = null;
        String cant = String.valueOf(cantidad);
        String mesa = NoMesa;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombre = rs.getString("nombre");
                descripcion = rs.getString("descripcion");
                precio = rs.getString("precio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        int c = 0;
        int j = 0;

        for (int i = 0; i < ventas.Ventas.tblDescripcion.getRowCount(); i++) {
            Object com = ventas.Ventas.tblDescripcion.getValueAt(i, 0);
            Object cant1 = ventas.Ventas.tblDescripcion.getValueAt(i, 3);
            if (codigo.equals(com)) {
                j = i;
                int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                ventas.Ventas.tblDescripcion.setValueAt(String.valueOf(cantT), i, 3);
                c++;
                calcular();
                ventas.Ventas.txtImporte.setText("");
                ventas.Ventas.txtCambio.setText("");
            }
        }
        if (c == 0) {

            dato[0] = codigo;
            dato[1] = nombre;
            dato[2] = descripcion;
            dato[3] = cant;
            dato[4] = precio;
            dato[6] = mesa;
            

            tabladet.addRow(dato);

            ventas.Ventas.tblDescripcion.setModel(tabladet);
            calcular();

            ventas.Ventas.txtImporte.setText("");
            ventas.Ventas.txtCambio.setText("");
        }
        System.out.println("El Array es: "+Arrays.toString(dato));
    }
    
    
    
//    
//    public static void actualizarVenta(String idTicket, String idProducto, int cantidad, String mesa) {
//        DefaultTableModel tabladet = (DefaultTableModel) ventas.Ventas.tblDescripcion.getModel();
//        String[] dato = new String[7];
//        int fila = ventas.Productos.tabla.getSelectedRow();
//        String sqlTicket = "select distinct idTicket, fecha, vendedor, SUM(total) as total, status from ticket WHERE idTicket='"+idTicket+"' group by idTicket";
//        
//        
//        String datosTicket[] = new String[3];
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sqlTicket);
//            while (rs.next()) {
//                
//                datosTicket[0] = rs.getString("fecha");
//                datosTicket[1] = rs.getString("vendedor");
//                datosTicket[2] = rs.getString("status");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sqlVentas = "SELECT * FROM ventas WHERE idventa = '" + idVenta(idTicket) + "'";
//        String datosVenta[] = new String[3];
//          try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sqlVentas);
//            while (rs.next()) {
//                datosVenta[0] = rs.getString("fecha");
//                datosVenta[1] = rs.getString("user");
//                datosVenta[2] = rs.getString("mesa");
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sqlProductos = "SELECT * FROM producto WHERE idproducto = '" + idProducto + "'";
//        String datosProducto[] = new String[1];
//          try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sqlProductos);
//            while (rs.next()) {
//                datosProducto[0] = rs.getString("precio");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          System.out.println(datosProducto[0]);
//        float total = Float.parseFloat(datosProducto[0]) * cantidad;
//        String datosVentaProceso[] = new String[1];
//                datosVentaProceso[0] = ventas.Ventas.numVenta.getText();
//                
//        String insert_ticket = "INSERT INTO ticket VALUES(?,?,?,?,?,?)";
//        System.out.println(insert_ticket);
//          int rsu1 = 0;
//         try {
//            ps = cn.prepareStatement(insert_ticket);
//            ps.setString(1, idTicket);
//            ps.setString(2, ventas.Ventas.numVenta.getText());
//            ps.setString(3, datosVenta[0]);
//            ps.setFloat(4, total);
//            ps.setString(5, datosVenta[1]);
//            ps.setString(6, datosTicket[2]);
//            
//            rsu1 = ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        
//        String insert_ventas = "INSERT INTO ventas VALUES(?,?,?,?,?,?,?)";
//        System.out.println(insert_ventas);
//          int rsu2 = 0;
//          
//         try {
//            ps = cn.prepareStatement(insert_ventas);
//            ps.setString(1, ventas.Ventas.numVenta.getText());
//            ps.setString(2, idProducto);
//            ps.setInt(3, cantidad);
//            ps.setFloat(4, total);
//            
//            ps.setString(5, datosVenta[0]);
//            
//            ps.setString(6, datosVenta[1]);
//            System.out.println("Entro 1");
//            ps.setString(7, mesa);
//            System.out.println("Entro 2");
//            rsu2 = ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//         System.out.println("Entro 3");
//         
//        String insert_ventasProceso = "INSERT INTO ventasProceso VALUES(?,?,?,?,?)";
//        System.out.println(insert_ventasProceso);
//          int rsu3 = 0;
//         try {
//            ps = cn.prepareStatement(insert_ventasProceso);
//            ps.setString(1, ventas.Ventas.numVenta1.getText());
//            ps.setString(2, ventas.Ventas.numVenta.getText());
//            ps.setFloat(3, total);
//            ps.setString(4, mesa);
//            ps.setString(5, datosTicket[2]);
//            rsu3 = ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

//    public static void numerosVenta() {
//        int c = 0;
//        String SQL = "SELECT MAX(idventa) FROM ventas";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            if (rs.next()) {
//                c = rs.getInt(1);
//            }
//
//            if (c == 0) {
//                ventas.Ventas.numVenta.setText("1");
//            } else {
//                ventas.Ventas.numVenta.setText(String.valueOf(c + 1));
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("error"+ex.getMessage());
//        }
//    }
//    public static void numerosTicket() {
//        int c = 0;
//        String SQL = "SELECT MAX(idTicket) FROM ticket";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            if (rs.next()) {
//                c = rs.getInt(1);
//            }
//
//            if (c == 0) {
//                ventas.Ventas.numVenta1.setText("1");
//            } else {
//                ventas.Ventas.numVenta1.setText(String.valueOf(c + 1));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

       

}

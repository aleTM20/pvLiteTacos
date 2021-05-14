package insumo;

import conexion.ConexionBD;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getInsumo());
            ps.setString(2, uc.getExistencia());
            ps.setString(3, uc.getUnidad_medida());
            ps.setDouble(4, uc.getPrecio_compra());
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
            ps.setString(1, uc.getInsumo());
            ps.setString(2, uc.getExistencia());
            ps.setString(3, uc.getUnidad_medida());
            ps.setDouble(4, uc.getPrecio_compra());
            ps.setInt(5, uc.getIdInsumo());
            rsu = ps.executeUpdate();
        } catch (SQLException localSQLException) {
        }
        return rsu;
    }

    public static int actualizarStock(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.ACTUALIZAR_STOCK;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getExistencia());
            ps.setInt(2, uc.getIdInsumo());

            rsu = ps.executeUpdate();
        } catch (SQLException localSQLException) {
        }
        return rsu;
    }

    public static int actualizarStockQuitar(int id, float existencia) {
        int rsu = 0;
        String sql = Sentencias.ACTUALIZAR_STOCK;
        try {
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, existencia);
            ps.setInt(2, id);

            rsu = ps.executeUpdate();
        } catch (SQLException localSQLException) {
        }
        return rsu;
    }

    public static float enExistencia(String codigo) {
        try {
            String sql = "SELECT * FROM insumos WHERE idInsumo = '" + codigo + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getFloat("existencias");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0F;
    }

    public static void calcular() {
        double total = 0.0D;

        double imp = 0.0D;

        for (int i = 0; i < Compras.tablaCompras.getRowCount(); i++) {
            String pre = Compras.tablaCompras.getValueAt(i, 4).toString();
            String can = Compras.tablaCompras.getValueAt(i, 3).toString();
            double precio = Double.parseDouble(pre);
            int cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            total += imp;
            Compras.tablaCompras.setValueAt(Double.valueOf(Math.rint(imp * 100.0D) / 100.0D), i, 5);
        }

        Compras.lblTotal.setText("" + Math.rint(total * 100.0D) / 100.0D);
    }

    public static void enviar(String codigo, int cantidad) {
        DefaultTableModel tabladet = (DefaultTableModel) Compras.tablaCompras.getModel();
        String[] dato = new String[7];
        int fila = Productos.tabla.getSelectedRow();

        String sql = "SELECT * FROM insumos WHERE idInsumo = '" + codigo + "'";

        String nombre = null;
        String cant = String.valueOf(cantidad);
        String unidad_medida = null;
        String precio = null;
        String exis = null;
        int total = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombre = rs.getString("insumo");
                unidad_medida = rs.getString("unidad_medida");
                precio = rs.getString("precio_compra");
                exis = rs.getString("existencias");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        int c = 0;
        int j = 0;
        total = Integer.parseInt(precio) * Integer.parseInt(cant);
        for (int i = 0; i < Compras.tablaCompras.getRowCount(); i++) {
            Object com = Compras.tablaCompras.getValueAt(i, 0);
            Object cant1 = Compras.tablaCompras.getValueAt(i, 3);
            if (codigo.equals(com)) {
                j = i;
                int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                Compras.tablaCompras.setValueAt(String.valueOf(cantT), i, 3);
                c++;
                calcular();
            }
        }
        if (c == 0) {
            dato[0] = codigo;
            dato[1] = nombre;
            dato[2] = exis;
            dato[3] = cant;
            dato[4] = precio;
            dato[5] = String.valueOf(total);
            dato[6] = unidad_medida;
            tabladet.addRow(dato);

            Compras.tablaCompras.setModel(tabladet);
            calcular();
        }
    }

    public static int actualizarStockCompra(Sentencias uc, float cantidad) {
        int rsu = 0;
        String sql = Sentencias.ACTUALIZAR_STOCK_COMPRA;
        try {
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, cantidad);
            ps.setInt(2, uc.getIdInsumo());
            rsu = ps.executeUpdate();
        } catch (SQLException localSQLException) {
        }
        System.out.println(sql);
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

    public static void listar2(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Productos.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM insumos WHERE (idInsumo LIKE'" + busca + "%' OR insumo LIKE'" + busca + "%' OR existencias LIKE'" + busca + "%' OR unidad_medida LIKE'" + busca + "%' OR precio_compra LIKE'" + busca + "%') ORDER BY idInsumo";
        }

        String[] datos = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idInsumo");
                datos[1] = rs.getString("insumo");
                datos[2] = rs.getString("existencias");
                datos[3] = rs.getString("unidad_medida");
                datos[4] = rs.getString("precio_compra");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) Insumos.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM insumos WHERE (idInsumo LIKE'" + busca + "%' OR insumo LIKE'" + busca + "%' OR existencias LIKE'" + busca + "%' OR unidad_medida LIKE'" + busca + "%' OR precio_compra LIKE'" + busca + "%') ORDER BY idInsumo";
        }

        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idInsumo");
                datos[1] = rs.getString("insumo");
                datos[2] = rs.getString("existencias");
                datos[3] = rs.getString("unidad_medida");
                datos[4] = rs.getString("precio_compra");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    public static void listarCompras(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) InsumosCompras.jTable1.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = "select DISTINCT(idCompra) as compra,fecha_gasto from compra inner join gastos on gastos.idgasto=compra.idgasto where compra.status='activo';";
        } else {
            sql = "select DISTINCT(idCompra) as compra,fecha_gasto from compra inner join gastos on gastos.idgasto=compra.idgasto where fecha_gasto='" + busca + "' and compra.status='activo'";
        }

        Object[] datos = new Object[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int cod = rs.getInt("compra");
                float total = optenTotal(cod);

                datos[0] = Integer.valueOf(cod);
                datos[1] = Float.valueOf(total);
                datos[2] = rs.getString("fecha_gasto");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("error en llenar compras: " + ex.getMessage());
        }
    }

    public static void listarInsumosVencidos(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) InsumosCaducidad.jTable1.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = "select * from insumoVencido;";
        } else {
            sql = "select * from insumoVencido where fechaDev='" + busca + "';";
        }

        Object[] datos = new Object[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.valueOf(rs.getInt("idInsumo"));
                datos[1] = rs.getString("insumo");
                datos[2] = Float.valueOf(rs.getFloat("cantidad"));
                datos[3] = rs.getString("fechaDev");

                modelo.addRow(datos);
            }
        } catch (Exception ex) {
            System.out.println("error en llenar compras: " + ex.getMessage());
        }
    }

    public static float optenTotal(int cod) {
        String SQL = "select sum(gastado) from compra  inner join gastos on gastos.idgasto=compra.idgasto  where idCompra=" + cod + ";";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0F;
    }

    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(idInsumo) FROM insumos";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void insertCompra(int compra, int gasto) {
        String sql = "insert into compra values(" + compra + "," + gasto + ",'activo')";
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en compra: " + ex.getMessage());
        }
    }

    public static void inactiveC(int compra) {
        String sql = "update compra set status ='inactivo' where idCompra=" + compra;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en compra inactivar: " + ex.getMessage());
        }
    }

    public static void obtenerInsumos(int id) {
        int c = 0;
        String SQL = "select  cantidad ,idInsumo from compra  inner join gastos on gastos.idgasto=compra.idgasto  where idCompra=" + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int idInsumo = rs.getInt("idInsumo");
                float hay = cantidadInsumo(idInsumo);
                float restar = rs.getFloat("cantidad");
                float total = hay - restar;
                System.out.println("hay: " + hay + " menos " + restar + " = " + total);
                sumarInsumo(idInsumo, total);
            }
        } catch (SQLException ex) {
            System.out.println("error sql obtener insumos-->" + ex.getMessage());
        }
    }

    public static int numeroGasto() {
        int c = 0;
        String SQL = "select MAX(idGasto) from gastos";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("error sql numero maximo gatso-->" + ex.getMessage());
        }
        return c;
    }

    public static void numerosCompra() {
        int c = 0;
        String SQL = "select MAX(idCompra) from compra";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
            }

            if (c == 0) {
                Compras.numCompra.setText("1");
            } else {
                Compras.numCompra.setText(String.valueOf(c + 1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void iniciarTransaccion() {
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void finalizarTransaccion() {
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cancelarTransaccion() {
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatofecha.format(fecha);
    }

    public static void listarInsumos() {
        DefaultTableModel modelo = (DefaultTableModel) fechCad.jTable1.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        sql = "select * from insumos;";

        Object[] datos = new Object[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.valueOf(rs.getInt("idInsumo"));
                datos[1] = rs.getString("insumo");
                datos[2] = Float.valueOf(rs.getFloat("existencias"));
                modelo.addRow(datos);
            }
        } catch (Exception ex) {
            System.out.println("error en llenar ventas: " + ex.getMessage());
        }
    }

    public static void insertInsumoVencido(int id, String Descripcion, float cantidad, String fecha) {
        String sql = "insert into insumoVencido values(?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, Descripcion);
            ps.setFloat(3, cantidad);
            ps.setString(4, fecha);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error en insertar devolucion: " + ex.getMessage());
        }
    }

    public static float cantidadInsumo(int codigo) {
        try {
            String sql = "select existencias as cantidad from insumos where idInsumo = " + codigo + ";";

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                return rs.getFloat("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("ver uni " + ex.getMessage());
        }
        return -1.0F;
    }

    public static void sumarInsumo(int idInsumo, float suma) {
        try {
            String sql = "update insumos set existencias = " + suma + " where idInsumo =" + idInsumo + ";";
            System.out.println(sql);
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("sumar inventario " + ex.getMessage());
        }
    }
}

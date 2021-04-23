package producto;

import componentes.org1.bolivia.combo.SComboBox;
import conexion.ConexionBD;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Opciones {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static void registrarInventario(int id, int cantidad) {
        String sql = "INSERT INTO inventario values(" + id + "," + cantidad + ");";
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
        String sql = "insert into producto values (?,?,?,?,?,?);";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getidProducto());
            ps.setString(2, uc.getNombre());
            ps.setString(3, uc.getDescripcion());
            ps.setString(4, uc.getTipo());
            ps.setDouble(5, uc.getPrecio().doubleValue());
            ps.setInt(6, 1);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return rsu;
    }

    public static int actualizar(Sentencias uc) {
        int rsu = 0;
        String sql = "update producto set nombre=?,descripcion=?,tipoproducto=?,precio=? where idproducto=?;";
        try {
            ps = cn.prepareStatement(sql);

            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getTipo());
            ps.setDouble(4, uc.getPrecio().doubleValue());
            ps.setInt(5, uc.getidProducto());

            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return rsu;
    }

    public static int eliminar(String id) {
        int rsu = 0;
        String sql = "update producto set status=2 WHERE idproducto = " + id;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("-->" + ex.getMessage());
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
        DefaultTableModel modelo = (DefaultTableModel) Productos.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM producto WHERE  status=1 and (idproducto LIKE'" + busca + "%' OR nombre LIKE'" + busca + "%' OR descripcion LIKE'" + busca + "%' OR tipoproducto LIKE'" + busca + "%' OR precio LIKE'" + busca + "%' OR idproducto LIKE'" + busca + "%' ) ORDER BY idproducto";
        }

        Object[] datos = new Object[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.valueOf(rs.getInt("idproducto"));
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
                datos[4] = rs.getString("precio");
                if (rs.getString("tipoproducto").equals("COMIDA")) {
                    datos[5] = "-------";
                } else {
                    datos[5] = Integer.valueOf(enInventario(rs.getString("idproducto")));
                }

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("error en llenar productos " + ex.getMessage());
        }
    }

    public static int enInventario(String id) {
        String SQL = "select * from inventario where idProducto=" + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                return rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("error en optener de inventarioo " + ex.getMessage());
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
                if (rs.getString(1) == null) {
                    c = "0";
                } else {
                    c = rs.getString(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    static void actualizarInvetario(int id, int validaStock) {
        String sql = "update inventario set cantidad=? where idproducto=?;";
        try {
            ps = cn.prepareStatement(sql);

            ps.setInt(1, validaStock);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void obtenerInsumos() {
        String SQL = "SELECT insumo,idInsumo FROM insumos ORDER BY insumo ASC";
        try {
            ModalIngredientesProducto.tipo.addItem("SELECCIONA UN INSUMO");
            ModalIngredientesProducto.idInsumo.add(Integer.valueOf(0));
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                ModalIngredientesProducto.tipo.addItem(rs.getString("insumo"));
                ModalIngredientesProducto.idInsumo.add(Integer.valueOf(rs.getInt("idInsumo")));
            }
        } catch (SQLException ex) {
            System.out.println("Error en listar insumos El error es: " + ex);
        }
    }

    public static int obtenerIdInsumo(String ins) {
        int lista = 0;
        String SQL = "SELECT idInsumo FROM insumos where insumo='" + ins + "'";
        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                lista = rs.getInt("idInsumo");
            }
        } catch (SQLException ex) {
            System.out.println("El error es: " + ex);
        }

        return lista;
    }

    public ArrayList obtenerUnidadesMedida() {
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
            System.out.println("El error es: " + ex);
        }

        return lista;
    }

    public void insertarReceta(int idProducto, int idInsumo, float cantidad) {
        String sql = "insert into reseta values(?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idInsumo);
            ps.setFloat(3, cantidad);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error inseratar receta " + ex);
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

    public static void commit() {
        try {
            cn.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cancelarTransaccion() {
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

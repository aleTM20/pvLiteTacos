/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;


/**
 *
 * @author Rojeru San CL
 */
public class Sentencias {

    public static String LISTAR = "SELECT * FROM producto GROUP BY nombre, descripcion ORDER BY tipoproducto";
    
    public static String LISTAR1 = "SELECT * FROM ventas, producto WHERE id_producto = idproducto";
    
    public static String LISTAR3 = "SELECT NoVenta, SUM(total) as total, NoMesa, status FROM ventasProceso GROUP BY NoMesa";
    
    public static String LISTAR_DETALLES = "select distinct idTicket, ventas.idventa, id_producto, cantidad, ventas.total,"
            + " ventas.fecha, mesa from ticket join ventas on ticket.idventa=ventas.idventa where idTicket=?";
    
    public static String LISTAR2 = "select distinct idTicket, fecha, vendedor, SUM(total) as total, status from ticket group by idTicket";
    public static String LISTAR_TICKET = "select distinct idTicket, fecha, vendedor, SUM(total) as total, status from ticket group by idTicket WHERE idTicket=?";

    public static String REGISTRAR = "INSERT INTO ventas(idventa, id_producto, cantidad, total, fecha, user, mesa) "
            + "VALUES(?,?,?,?,?,?,?)";
    public static String REGISTRAR_TICKET = "INSERT INTO ticket(idTicket, idventa, fecha, total, vendedor, status) "
            + "VALUES(?,?,?,?,?,?)";
    public static String REGISTRAR_VENTAS_PROCESO = "INSERT INTO ventasProceso(idTicket, NoVenta, total, NoMesa, status) "
            + "VALUES(?,?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE producto SET "
            + "nombre=?, "
            + "descripcion=?, "
            + "tipoproducto=?, "
            + "precio=? "
            + "WHERE idproducto=?";

    public static String ELIMINAR = "DELETE FROM ventas WHERE idventa = ?";

    public static String ELIMINAR_TODO = "TRUNCATE TABLE ventas";

    private int id_venta;
    private String id_producto;
    private int cantidad;
    private double total;
    private String fecha;
    private String usuario;
    private int mesa;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
   
}

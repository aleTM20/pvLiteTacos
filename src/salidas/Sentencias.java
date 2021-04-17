/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salidas;

import java.util.Date;

/**
 *
 * @author Rojeru San CL
 */
public class Sentencias {

    public static String LISTAR = "SELECT * FROM gastos ORDER BY idgasto";

    public static String REGISTRAR = "INSERT INTO gastos(descripcion, gastado, fecha_gasto) "
            + "VALUES(?,?,?)";

    public static String ACTUALIZAR = "UPDATE gastos SET "
            + "descripcion=?, "
            + "gastado=?, "
            + "fecha_gasto=? "
            + "WHERE idgasto=?";

    public static String ELIMINAR = "DELETE FROM gastos WHERE idgasto = ?";

    public static String ELIMINAR_TODO = "TRUNCATE TABLE gastos";

    private int idgasto;
    private String descripcion;
    private double gastado;
    private String fecha;
    private java.util.Date date = new Date();
    private java.sql.Date fechaActual = new java.sql.Date(date.getTime());

    public int getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getGastado() {
        return gastado;
    }

    public void setGastado(double gastado) {
        this.gastado = gastado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.sql.Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(java.sql.Date fechaActual) {
        this.fechaActual = fechaActual;
    }
     
    
}

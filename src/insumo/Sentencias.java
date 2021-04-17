/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insumo;

import producto.*;

/**
 *
 * @author Rojeru San CL
 */
public class Sentencias {

    public static String LISTAR = "SELECT * FROM insumos ORDER BY insumo";
    public static String LISTAR2 = "select * from gastos order by fecha_gasto";
    public static String LISTAR_AL = "SELECT * FROM producto WHERE stock!='' ORDER BY tipoproducto";

    public static String REGISTRAR = "INSERT INTO insumos(insumo, existencias, unidad_medida, precio_compra) "
            + "VALUES(?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE insumos SET "
            + "insumo=?, "
            + "existencias=?, "
            + "unidad_medida=?, "
            + "precio_compra=? "
            + "WHERE idInsumo=?";
    
    public static String ACTUALIZAR_STOCK = "UPDATE insumos SET "
            + "existencias=? "
            + "WHERE idInsumo=?";

      public static String ACTUALIZAR_STOCK_COMPRA = "UPDATE insumos SET "
            + "existencias=existencias+? "
            + "WHERE idInsumo=?";
    
    public static String ELIMINAR = "DELETE FROM insumos WHERE idInsumo = ?";

    public static String ELIMINAR_TODO = "TRUNCATE TABLE insumos";

    private int idInsumo;
    private String insumo;
    private String existencia;
    private String unidad_medida;
    private double precio_compra;

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }
    

}

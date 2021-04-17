/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insumo;

/**
 *
 * @author cesar
 */
public class listar {
    private String insumo;
    private float existencias;
    private String unidad_medida;
    private float precio_compra;

    public listar(String insumo, float existencias, String unidad_medida, float precio_compra) {
        this.insumo = insumo;
        this.existencias = existencias;
        this.unidad_medida = unidad_medida;
        this.precio_compra = precio_compra;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public float getExistencias() {
        return existencias;
    }

    public void setExistencias(float existencias) {
        this.existencias = existencias;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }
    
    
}

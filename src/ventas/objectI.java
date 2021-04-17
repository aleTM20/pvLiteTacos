/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *
 * @author Alejandro
 */
public class objectI {
    private int idInsumo;
    private float resta;

    public objectI(int idInsumo, float resta) {
        this.idInsumo = idInsumo;
        this.resta = resta;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public float getResta() {
        return resta;
    }

    public void setResta(float resta) {
        this.resta = resta;
    }
    
}

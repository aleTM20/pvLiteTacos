package salidas;

public class Sentencias {

    public static String LISTAR = "SELECT * FROM gastos ORDER BY idgasto";

    public static String REGISTRAR = "INSERT INTO gastos(descripcion, gastado, fecha_gasto,cantidad,idInsumo) VALUES(?,?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE gastos SET descripcion=?, gastado=?, fecha_gasto=? ,cantidad=0 WHERE idgasto=?";

    public static String ELIMINAR = "DELETE FROM gastos WHERE idgasto = ?";

    public static String ELIMINAR_TODO = "TRUNCATE TABLE gastos";
    private int idgasto;
    private int idInsumo;
    private String descripcion;
    private double gastado;
    private String fecha;
    private float cantidad;
    private java.util.Date date = new java.util.Date();
    private java.sql.Date fechaActual = new java.sql.Date(this.date.getTime());

    public int getIdgasto() {
        return this.idgasto;
    }

    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }

    public int getidInsumo() {
        return this.idInsumo;
    }

    public void setInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getCantidad() {
        return this.cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getGastado() {
        return this.gastado;
    }

    public void setGastado(double gastado) {
        this.gastado = gastado;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public java.util.Date getDate() {
        return this.date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public java.sql.Date getFechaActual() {
        return this.fechaActual;
    }

    public void setFechaActual(java.sql.Date fechaActual) {
        this.fechaActual = fechaActual;
    }
}

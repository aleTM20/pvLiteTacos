package producto;

public class Sentencias {

    public static String LISTAR = "SELECT * FROM producto where STATUS=1 ORDER BY idproducto";
    public static String LISTAR_AL = "SELECT * FROM producto WHERE stock!='' ORDER BY tipoproducto";
    public static String LISTAR_INSUMOS = "SELECT * FROM insumos ";

    public static String ACTUALIZAR_STOCK = "UPDATE producto SET stock=? WHERE idproducto=?";

    public static String ELIMINAR = "update producto set status=1 WHERE idproducto = ?";

    public static String ELIMINAR_TODO = "update producto set status=2";
    private int idProducto;
    private String nombre;
    private String descripcion;
    private String tipo;
    private double precio;
    private int status;

    public int getidProducto() {
        return this.idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return Double.valueOf(this.precio);
    }

    public void setPrecio(Double precio) {
        this.precio = precio.doubleValue();
    }
}

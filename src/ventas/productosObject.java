/*    */ package ventas;
/*    */ 
/*    */ public class productosObject
/*    */ {
/*    */   private int cantidad;
/*    */   private String producto;
/*    */   private float precioUnitario;
/*    */   private float total;
/*    */ /*    */ 
/*    */   public productosObject(int cantidad, String producto, float precioUnitario, float total)
/*    */   {
/* 19 */     this.cantidad = cantidad;
/* 20 */     this.producto = producto;
/* 21 */     this.precioUnitario = precioUnitario;
/* 22 */     this.total = total;
/*    */   }
/*    */ 
/*    */   public int getCantidad() {
/* 26 */     return this.cantidad;
/*    */   }
/*    */ 
/*    */   public String getProducto() {
/* 30 */     return this.producto;
/*    */   }
/*    */ 
/*    */   public float getPrecioUnitario() {
/* 34 */     return this.precioUnitario;
/*    */   }
/*    */ 
/*    */   public float getTotal() {
/* 38 */     return this.total;
/*    */   }
/*    */ }

/* Location:           C:\Users\aleja\Downloads\TaquitosToluca\TacosT.jar
 * Qualified Name:     ventas.productosObject
 * JD-Core Version:    0.6.2
 */
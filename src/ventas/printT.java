/*    */ package ventas;
/*    */ 
/*    */ import java.awt.print.PrinterException;
/*    */ import java.awt.print.PrinterJob;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class printT
/*    */ {
/*    */   public static String hora;
/*    */   public static String fecha;
/*    */   public static int ticketUltimo;
/*    */   public static ArrayList<productosObject> productos;
/*    */   public static float total;
/*    */   public static float efectivo;
/*    */   public static float cambio;
/*    */ /*    */ 
/*    */   public printT(String hora, String fecha, int ticket, ArrayList<productosObject> productos, float total, float efectivo, float cambio)
/*    */   {
/* 26 */     hora = hora;
/* 27 */     fecha = fecha;
/* 28 */     ticketUltimo = ticket;
/* 29 */     productos = productos;
/* 30 */     total = total;
/* 31 */     efectivo = efectivo;
/* 32 */     cambio = cambio;
/*    */ 
/* 34 */     PrinterJob pj = PrinterJob.getPrinterJob();
/* 35 */     BillPrintable a = new BillPrintable();
/* 36 */     pj.setPrintable(new BillPrintable(), a.getPageFormat(pj));
/*    */     try {
/* 38 */       pj.print();
/*    */     }
/*    */     catch (PrinterException ex)
/*    */     {
/* 42 */       System.out.println("-->" + ex.getMessage());
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\aleja\Downloads\TaquitosToluca\TacosT.jar
 * Qualified Name:     ventas.printT
 * JD-Core Version:    0.6.2
 */
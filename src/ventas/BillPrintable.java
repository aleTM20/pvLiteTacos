package ventas;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class BillPrintable implements Printable {

    private String hora;
    private String fecha;
    private int ticketUltimo;
    private List<productosObject> productos;
    private float total;
    private float efectivo;
    private float cambio;

    public BillPrintable(String hora, String fecha, int ticketUltimo, ArrayList<productosObject> productos, float total, float efectivo, float cambio) {
        this.hora = hora;
        this.fecha = fecha;
        this.ticketUltimo = ticketUltimo;
        this.productos = productos;
        this.total = total;
        this.efectivo = efectivo;
        this.cambio = cambio;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787D);
    }

    protected static double toPPI(double inch) {
        return inch * 72.0D;
    }

    public PageFormat getPageFormat(PrinterJob pj) {
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 8.0D;
        double headerHeight = 2.0D;
        double footerHeight = 2.0D;
        double width = convert_CM_To_PPI(8.0D);
        double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0.0D, 10.0D, width, 800.0D);

        pf.setOrientation(1);
        pf.setPaper(paper);

        return pf;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int result = 1;
        if (pageIndex == 0) {
            Graphics2D g2d = (Graphics2D) graphics;

            double width = pageFormat.getImageableWidth();

            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            FontMetrics metrics = g2d.getFontMetrics(new Font("Tahoma", 2, 10));

            int idLength = metrics.stringWidth("000");
            int amtLength = metrics.stringWidth("000000");
            int qtyLength = metrics.stringWidth("00000");
            int priceLength = metrics.stringWidth("000000");
            int prodLength = (int) width - idLength - amtLength - qtyLength - priceLength - 17;
            try {
                int y = 20;
                int yShift = 10;
                int headerRectHeight = 15;
                int headerRectHeighta = 40;

                g2d.setFont(new Font("Arial", 0, 10));

                String dirName = "C:\\TaquitosToluca";
                BufferedImage img = ImageIO.read(new File(dirName, "la161.jpg"));
                g2d.drawImage(img, null, 30, 0);
                y = 130;
                g2d.drawString("       TAQUITOS TOLUCA S.A de C.V   ", 15, y);
                y += yShift;
                g2d.drawString("       Atlacomulco, Edo. de Mexico  ", 15, y);
                y += yShift;
                g2d.drawString(" Fecha:" + this.fecha + "     Hora:" + this.hora, 18, y);
                y += yShift;
                g2d.drawString(" Ticket: " + this.ticketUltimo, 18, y);
                y += headerRectHeight;
                g2d.drawLine(200, y + 2, 12, y + 2);
                g2d.drawString("Cant.     Producto                P/U        Total", 12, y + 1);
                y += yShift;
                g2d.setFont(new Font("Courier New", 3, 8));
                for (int i = 0; i < this.productos.size(); i++) {
                    productosObject product = this.productos.get(i);
                    g2d.drawString(space(product.getCantidad() + "", product.getProducto(), product.getPrecioUnitario() + "", product.getTotal() + ""), 15, y);
                    y += yShift;
                }
                g2d.drawLine(200, y, 12, y);
                y += yShift + 5;
                g2d.setFont(new Font("Arial", 1, 15));
                g2d.drawString(" Cantidad Total: $" + this.total + "", 12, y);
                y += yShift;
                g2d.setFont(new Font("Arial", 0, 12));
                g2d.drawString(" Efectivo : $" + this.efectivo + "", 12, y);
                y += yShift;
                g2d.drawString(" Cambio  :  $" + this.cambio + "", 12, y);
                y += yShift;
                g2d.setFont(new Font("Arial", 0, 10));
                g2d.drawString("              Gracias por su preferencia   ", 15, y);
                y += yShift;
                g2d.drawString("***********************************************", 15, y);
                y += yShift;
            } catch (IOException exception) {
                throw new PrinterException(exception.getMessage());
            }
            result = 0;
        }
        return result;
    }

    public static String space(String cant, String producto, String sub, String total) {
        int lonC = 5;
        int lonP = 20;
        int lonPu = 8;
        int lonT = 5;

        return cadena(cant.length(), lonC, cant) + cadena(producto.length(), lonP, producto) + cadena(sub.length(), lonPu, sub) + cadena(total.length(), lonT, total);
    }

    public static String cadena(int longitudPalabra, int lon, String palabra) {
        boolean start = false;
        if (longitudPalabra > lon) {
            return palabra.substring(0, 19) + " ";
        }
        for (int i = 0; i < lon; i++) {
            if ((i == longitudPalabra) || (start)) {
                palabra = palabra + " ";
                start = true;
            }
        }
        return palabra;
    }
}

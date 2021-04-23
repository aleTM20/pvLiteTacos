package ventas;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

public class printT {

    public printT(String hora, String fecha, int ticket, ArrayList<productosObject> productos, float total, float efectivo, float cambio) {

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        BillPrintable billPrintable = new BillPrintable(hora, fecha, ticket, productos, total, efectivo, cambio);
        printerJob.setPrintable(billPrintable, billPrintable.getPageFormat(printerJob));
        try {
            printerJob.print();
        } catch (PrinterException ex) {
            System.out.println("-->" + ex.getMessage());
        }
    }
}

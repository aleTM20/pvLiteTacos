package tabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class EstiloTablaRenderer extends DefaultTableCellRenderer {

    private Component componenete;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(0);
        setBorder(null);
        table.setRowHeight(30);
        setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(58, 159, 171)));
        this.componenete.setFont(new Font("Tahoma", 1, 18));

        if (row % 2 == 0) {
            this.componenete.setForeground(new Color(58, 159, 171));
            this.componenete.setBackground(new Color(255, 255, 255));
        } else {
            this.componenete.setForeground(new Color(58, 159, 171));
            this.componenete.setBackground(new Color(255, 255, 255));
        }

        if (isSelected) {
            this.componenete.setForeground(Color.white);
            this.componenete.setBackground(new Color(32, 178, 170));
            this.componenete.setFont(new Font("Tahoma", 1, 20));
        }

        return this.componenete;
    }
}

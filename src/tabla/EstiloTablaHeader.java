package tabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class EstiloTablaHeader
        implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
        JComponent jcomponent = null;

        if ((value instanceof String)) {
            jcomponent = new JLabel("   " + value);
            ((JLabel) jcomponent).setHorizontalAlignment(0);
            ((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(3, jcomponent.getWidth()));
        }

        jcomponent.setEnabled(true);

        jcomponent.setOpaque(true);
        jcomponent.setBackground(new Color(58, 159, 171));
        jcomponent.setForeground(Color.WHITE);
        jcomponent.setFont(new Font("Tahoma", 1, 15));

        return jcomponent;
    }
}

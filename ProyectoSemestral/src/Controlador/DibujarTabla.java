package Controlador;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Haleym Hidalgo
 */
public class DibujarTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj_renderizable, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(obj_renderizable instanceof JButton){
            return (JButton) obj_renderizable;
        }
        
        return super.getTableCellRendererComponent(table, obj_renderizable, isSelected, hasFocus, row, column);
    }

}

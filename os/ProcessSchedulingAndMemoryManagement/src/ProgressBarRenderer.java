
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class ProgressBarRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private final JProgressBar b;
    private ArrayList<PCBUnit> PCBList;

    public ProgressBarRenderer(ArrayList<PCBUnit> list) {
        this.setOpaque(true);
        this.PCBList = list;
        this.b = new JProgressBar();
        this.b.setStringPainted(true);
        this.b.setMinimum(0);
        this.b.setMaximum(100);
        this.b.setBorderPainted(true);
        this.b.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            this.b.setValue(((PCBUnit)this.PCBList.get(row)).getComplete());
            return this.b;
        } catch (Exception var8) {
            return null;
        }
    }
}

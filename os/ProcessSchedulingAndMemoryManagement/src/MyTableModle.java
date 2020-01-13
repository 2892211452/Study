

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableModle extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private ArrayList<PCBUnit> pcbList;

    public MyTableModle(ArrayList<PCBUnit> pcbList) {
        this.pcbList = pcbList;
    }

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        return this.pcbList.size() > 0 ? this.pcbList.size() : 0;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            if (this.pcbList.size() > 0) {
                if (columnIndex == 0) {
                    return ((PCBUnit)this.pcbList.get(rowIndex)).getPid();
                } else if (columnIndex == 1) {
                    return "" + ((PCBUnit)this.pcbList.get(rowIndex)).getRuntime();
                } else if (columnIndex == 2) {
                    return "" + ((PCBUnit)this.pcbList.get(rowIndex)).getTime();
                } else if (columnIndex == 3) {
                    return "" + ((PCBUnit)this.pcbList.get(rowIndex)).getPri();
                } else if (columnIndex == 4) {
                    return ((PCBUnit)this.pcbList.get(rowIndex)).getMemery() + "KB";
                } else {
                    return columnIndex == 6 ? ((PCBUnit)this.pcbList.get(rowIndex)).getState() : "";
                }
            } else {
                return "";
            }
        } catch (Exception var4) {
            return "";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public String getColumnName(int column) {
        if (column == 0) {
            return "进程名";
        } else if (column == 1) {
            return "运行时间";
        } else if (column == 2) {
            return "剩余时间";
        } else if (column == 3) {
            return "优先级";
        } else if (column == 4) {
            return "占用内存";
        } else {
            return column == 6 ? "进程状态" : "完成进度";
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

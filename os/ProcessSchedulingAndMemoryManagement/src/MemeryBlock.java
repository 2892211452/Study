
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MemeryBlock extends JPanel {
    private int height;
    public int start;
    public int end;
    public int x;
    public int y;
    private String pId;
    private JLabel name;
    private PCBUnit pcb;

    public String getpId() {
        return this.pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public MemeryBlock(int height, PCBUnit pcb) {
        this.height = height;
        this.setPcb(pcb);
        this.pId = pcb.getPid();
        this.setBorder(new LineBorder(Color.BLACK, 1));
        this.name = new JLabel(pcb.getPid() + "内存：" + pcb.getMemery());
        this.add(this.name);
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPcb(PCBUnit pcb) {
        this.pcb = pcb;
    }

    public PCBUnit getPcb() {
        return this.pcb;
    }
}

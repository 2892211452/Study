

import javax.swing.JPanel;

public class FreeBlock extends JPanel {
    public int x;
    public int y = 30;
    public int height;

    public FreeBlock() {
    }

    public FreeBlock(int y, int height) {
        this.y = y;
        this.height = height;
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

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "空闲块起始位置：" + this.y + "__" + "空闲块宽度:" + this.height + ";";
    }
}

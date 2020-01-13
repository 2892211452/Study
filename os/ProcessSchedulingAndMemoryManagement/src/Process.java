

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class Process extends JFrame {
    private static final int MAXMEMERY = 450;
    private int allUseMemery = 30;
    private static final long serialVersionUID = 1L;
    private static int count = 0;
    public ArrayList<PCBUnit> readyList;
    public ArrayList<PCBUnit> waitList;
    public ArrayList<PCBUnit> holdList;
    public ArrayList<FreeBlock> freeList;
    public ArrayList<MemeryBlock> blocks;
    public MemeryBlock block;
    private JMenuBar menuBar;
    private JMenu operate;
    private JMenu set;
    private JMenu about;
    private JMenuItem randOne;
    private JMenuItem exit;
    private JMenuItem aboutProgram;
    private JTabbedPane tabbedpane;
    private JTable readyTable;
    private JTable waitTable;
    private JTable holdTable;
    private JPanel allMemery;
    private JPanel memeryPane;
    private JButton start;
    private JButton hold;
    private JButton stop;
    private JButton notify;
    private JLabel all;
    private JLabel cpu;
    private JLabel mem;
    private JLabel runnow;
    private TableModel readyModle;
    private TableModel waitModle;
    private TableModel holdModle;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextArea info;
    private boolean checkItems = true;
    private TableColumn readyColmn;
    private TableColumn waitColumn;
    private TableColumn holdColumn;
    private Random rand = new Random();
    private JPopupMenu pop1;
    private JPopupMenu pop2;
    private JMenuItem holdProcess;
    private JMenuItem stopProcess;
    private JMenuItem aboutProcess1;
    private JMenuItem notifyProcess;
    private JMenuItem aboutProcess2;
    private FreeBlock free = new FreeBlock();
    private int addTime = 0;

    public Process() {
        this.setBounds(220, 60, 600, 600);
        this.setTitle("处理机调度及内存分配模拟");
        this.setLayout(new BorderLayout());
        this.menuBar = new JMenuBar();
        this.operate = new JMenu("操作");
        this.set = new JMenu("设置");
        this.about = new JMenu("关于");
        this.menuBar.add(this.operate);
        this.menuBar.add(this.set);
        this.menuBar.add(this.about);
        this.randOne = new JMenuItem("随机加入进程");
        this.exit = new JMenuItem("退出");
        this.operate.add(this.randOne);
        this.operate.addSeparator();
        this.operate.add(this.exit);
        this.aboutProgram = new JMenuItem("说明");
        this.about.add(this.aboutProgram);
        this.readyList = new ArrayList();
        this.waitList = new ArrayList();
        this.holdList = new ArrayList();
        this.freeList = new ArrayList();
        this.blocks = new ArrayList();
        this.free.setHeight(420);
        this.freeList.add(this.free);
        this.pop1 = new JPopupMenu();
        this.stopProcess = new JMenuItem("结束进程");
        this.pop1.add(this.stopProcess);
        this.pop1.addSeparator();
        this.holdProcess = new JMenuItem("挂起进程");
        this.pop1.add(this.holdProcess);
        this.pop1.addSeparator();
        this.aboutProcess1 = new JMenuItem("查看进程信息");
        this.pop1.add(this.aboutProcess1);
        this.pop2 = new JPopupMenu();
        this.notifyProcess = new JMenuItem("解挂进程");
        this.pop2.add(this.notifyProcess);
        this.pop2.addSeparator();
        this.aboutProcess2 = new JMenuItem("查看信息");
        this.pop2.add(this.aboutProcess2);
        JPanel p1 = new JPanel();
        p1.setSize(50, 600);
        JPanel p2 = new JPanel();
        p1.setSize(50, 600);
        JPanel p3 = new JPanel();
        p3.setSize(600, 200);
        this.start = new JButton("Start");
        this.hold = new JButton("Hold");
        this.stop = new JButton("Stop");
        this.notify = new JButton("Notify");
        this.t4 = new JTextField(30);
        this.t4.setEditable(false);
        this.t4.setText("当前无进程运行！");
        this.runnow = new JLabel("当前处理进程：");
        this.all = new JLabel("总进程数");
        this.cpu = new JLabel("CPU使用");
        this.mem = new JLabel("内存使用");
        this.t1 = new JTextField(5);
        this.t1.setText("0");
        this.t2 = new JTextField(5);
        this.t2.setText(this.rand.nextInt(10) + "%");
        this.t3 = new JTextField(10);
        this.t3.setText(this.allUseMemery + "/" + 450);
        this.t1.setEditable(false);
        this.t2.setEditable(false);
        this.t3.setEditable(false);
        p3.setLayout(new FlowLayout(0));
        p3.add(this.runnow);
        p3.add(this.t4);
        p3.add(this.start);
        p3.add(this.hold);
        p3.add(this.notify);
        p3.add(this.stop);
        p3.setBorder(new LineBorder(Color.GRAY, 1));
        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(0));
        p5.add(this.all);
        p5.add(this.t1);
        p5.add(this.cpu);
        p5.add(this.t2);
        p5.add(this.mem);
        p5.add(this.t3);
        JPanel p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        p4.add(p3, "North");
        p4.add(p5, "South");
        this.add(p1, "East");
        this.add(p2, "West");
        this.add(p4, "South");
        this.tabbedpane = new JTabbedPane();
        this.readyModle = new MyTableModle(this.readyList);
        this.readyTable = new JTable();
        this.readyTable.setModel(this.readyModle);
        this.readyTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        this.readyTable.setAutoResizeMode(4);
        this.readyTable.setBorder(new LineBorder(Color.BLACK, 1));
        this.readyTable.setRowHeight(25);
        this.readyTable.setFont(new Font("宋体", 2, 15));
        JScrollPane scroll = new JScrollPane(this.readyTable);
        this.readyColmn = this.readyTable.getColumn(this.readyModle.getColumnName(5));
        this.readyColmn.setCellRenderer(new ProgressBarRenderer(this.readyList));
        this.waitModle = new MyTableModle(this.waitList);
        this.waitTable = new JTable(this.waitModle);
        this.waitTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        this.waitTable.setAutoResizeMode(4);
        this.waitTable.setBorder(new LineBorder(Color.BLACK, 1));
        this.waitTable.setRowHeight(25);
        this.waitTable.setFont(new Font("宋体", 2, 15));
        JScrollPane scroll2 = new JScrollPane(this.waitTable);
        this.waitColumn = this.waitTable.getColumn(this.waitModle.getColumnName(5));
        this.waitColumn.setCellRenderer(new ProgressBarRenderer(this.waitList));
        this.holdModle = new MyTableModle(this.holdList);
        this.holdTable = new JTable(this.holdModle);
        this.holdTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        this.holdTable.setAutoResizeMode(4);
        this.holdTable.setBorder(new LineBorder(Color.BLACK, 1));
        this.holdTable.setRowHeight(25);
        this.holdTable.setFont(new Font("宋体", 2, 15));
        JScrollPane scroll3 = new JScrollPane(this.holdTable);
        this.holdColumn = this.holdTable.getColumn(this.holdModle.getColumnName(5));
        this.holdColumn.setCellRenderer(new ProgressBarRenderer(this.holdList));
        this.allMemery = new JPanel();
        this.allMemery.setBounds(380, 0, 100, 450);
        this.allMemery.setBorder(new LineBorder(Color.BLACK, 1));
        this.allMemery.setBackground(Color.LIGHT_GRAY);
        this.allMemery.setLayout((LayoutManager)null);
        JLabel label = new JLabel("系统占用");
        JPanel operation = new JPanel();
        operation.setBounds(0, 0, 99, 30);
        operation.setBackground(Color.GREEN);
        operation.setBorder(new LineBorder(Color.BLACK, 1));
        operation.add(label);
        this.allMemery.add(operation);
        JTextField freeLabel = new JTextField("空闲内存块信息:");
        freeLabel.setBounds(5, 5, 100, 30);
        freeLabel.setEditable(false);
        freeLabel.setBackground(Color.LIGHT_GRAY);
        freeLabel.setBorder(new LineBorder(Color.BLACK, 1));
        freeLabel.setFont(new Font("宋体", 2, 12));
        JTextField memeryInfo = new JTextField(" 内存块信息 :");
        memeryInfo.setBounds(270, 5, 100, 30);
        memeryInfo.setEditable(false);
        memeryInfo.setBackground(Color.LIGHT_GRAY);
        memeryInfo.setBorder(new LineBorder(Color.BLACK, 1));
        memeryInfo.setFont(new Font("宋体", 2, 12));
        this.info = new JTextArea();
        this.info.setBackground(new Color(50, 200, 10));
        this.info.setEditable(false);
        this.info.setLineWrap(true);
        this.info.setText(this.freeList.toString());
        this.info.setBorder(new LineBorder(Color.BLACK, 2));
        this.info.setBounds(30, 60, 250, 250);
        this.t5 = new JTextField("无新加进程，请添加！");
        this.t5.setEditable(false);
        this.t5.setBorder(new LineBorder(Color.BLACK, 1));
        this.t5.setBounds(5, 380, 350, 30);
        this.t5.setBackground(Color.LIGHT_GRAY);
        this.t5.setFont(new Font("宋体", 2, 15));
        JTextField jf = new JTextField(" 新加入就绪队列进程信息 :");
        jf.setBounds(5, 330, 185, 30);
        jf.setEditable(false);
        jf.setBackground(Color.LIGHT_GRAY);
        jf.setBorder(new LineBorder(Color.BLACK, 1));
        jf.setFont(new Font("宋体", 2, 15));
        this.memeryPane = new JPanel();
        this.memeryPane.setLayout((LayoutManager)null);
        this.memeryPane.add(freeLabel);
        this.memeryPane.add(memeryInfo);
        this.memeryPane.add(this.info);
        this.memeryPane.add(jf);
        this.memeryPane.add(this.t5);
        this.memeryPane.add(this.allMemery);
        this.tabbedpane.add(scroll, "运行进程");
        this.tabbedpane.add(scroll2, "等待进程");
        this.tabbedpane.add(scroll3, "挂起进程");
        this.tabbedpane.add(this.memeryPane, "内存状况");
        this.add(this.tabbedpane);
        this.setJMenuBar(this.menuBar);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setResizable(false);
        ActionListener myActionListener = new Process.Action();
        MouseListener mouse1 = new Process.Mouse(this.pop1);
        MouseListener mouse2 = new Process.Mouse(this.pop2);
        this.randOne.addActionListener(myActionListener);
        this.hold.addActionListener(myActionListener);
        this.stop.addActionListener(myActionListener);
        this.notify.addActionListener(myActionListener);
        this.start.addActionListener(myActionListener);
        this.stopProcess.addActionListener(myActionListener);
        this.holdProcess.addActionListener(myActionListener);
        this.aboutProcess1.addActionListener(myActionListener);
        this.aboutProcess2.addActionListener(myActionListener);
        this.notifyProcess.addActionListener(myActionListener);
        this.aboutProgram.addActionListener(myActionListener);
        this.exit.addActionListener(myActionListener);
        this.readyTable.addMouseListener(mouse1);
        this.holdTable.addMouseListener(mouse2);
    }

    public void rePaint() {
        int i;
        int j;
        PCBUnit temp;
        for(i = 0; i < this.readyList.size() - 1; ++i) {
            for(j = i + 1; j < this.readyList.size(); ++j) {
                if (((PCBUnit)this.readyList.get(i)).getPri() < ((PCBUnit)this.readyList.get(j)).getPri()) {
                    temp = (PCBUnit)this.readyList.get(i);
                    this.readyList.set(i, (PCBUnit)this.readyList.get(j));
                    this.readyList.set(j, temp);
                }
            }
        }

        for(i = 0; i < this.waitList.size() - 1; ++i) {
            for(j = i + 1; j < this.waitList.size(); ++j) {
                if (((PCBUnit)this.waitList.get(i)).getPri() < ((PCBUnit)this.waitList.get(j)).getPri()) {
                    temp = (PCBUnit)this.waitList.get(i);
                    this.waitList.set(i, (PCBUnit)this.waitList.get(j));
                    this.waitList.set(j, temp);
                }
            }
        }

        for(i = 0; i < this.holdList.size() - 1; ++i) {
            for(j = i + 1; j < this.holdList.size(); ++j) {
                if (((PCBUnit)this.holdList.get(i)).getPri() < ((PCBUnit)this.holdList.get(j)).getPri()) {
                    temp = (PCBUnit)this.holdList.get(i);
                    this.holdList.set(i, (PCBUnit)this.holdList.get(j));
                    this.holdList.set(j, temp);
                }
            }
        }

        ((AbstractTableModel)this.readyModle).fireTableDataChanged();
        this.readyColmn = this.readyTable.getColumn(this.readyModle.getColumnName(5));
        this.readyColmn.setCellRenderer(new ProgressBarRenderer(this.readyList));
        ((AbstractTableModel)this.waitModle).fireTableDataChanged();
        this.waitColumn = this.waitTable.getColumn(this.waitModle.getColumnName(5));
        this.waitColumn.setCellRenderer(new ProgressBarRenderer(this.waitList));
        ((AbstractTableModel)this.holdModle).fireTableDataChanged();
        this.holdColumn = this.holdTable.getColumn(this.holdModle.getColumnName(5));
        this.holdColumn.setCellRenderer(new ProgressBarRenderer(this.holdList));
    }

    public boolean checkPid(String pid) {
        Iterator var3 = this.readyList.iterator();

        PCBUnit temp3;
        while(var3.hasNext()) {
            temp3 = (PCBUnit)var3.next();
            if (pid.equals(temp3.getPid())) {
                return false;
            }
        }

        var3 = this.waitList.iterator();

        while(var3.hasNext()) {
            temp3 = (PCBUnit)var3.next();
            if (pid.equals(temp3.getPid())) {
                return false;
            }
        }

        var3 = this.holdList.iterator();

        while(var3.hasNext()) {
            temp3 = (PCBUnit)var3.next();
            if (pid.equals(temp3.getPid())) {
                return false;
            }
        }

        return true;
    }

    public void readyProcessAdd() {
        for(int i = 1; i < this.readyList.size(); ++i) {
            ((PCBUnit)this.readyList.get(i)).setPri(((PCBUnit)this.readyList.get(i)).getPri() + 1);
        }

    }

    public PCBUnit randOne() {
        Random rand = new Random();
        int tempTime = rand.nextInt(8) + 1;
        PCBUnit temp = new PCBUnit("P" + rand.nextInt(50) + ".exe", tempTime, tempTime, tempTime + 1, "ready", rand.nextInt(25) + 20, count++);
        return temp;
    }

    public void mergeBeforButton() {
        this.sortFreeList();
        boolean flag = false;

        for(int i = 0; i < this.freeList.size() - 1; ++i) {
            flag = true;

            while(flag) {
                FreeBlock tempmegerBlock;
                int tempY;
                int tempHeight;
                if (this.freeList.size() > 2) {
                    tempmegerBlock = (FreeBlock)this.freeList.get(i);
                    if (tempmegerBlock.getY() + tempmegerBlock.getHeight() == ((FreeBlock)this.freeList.get(i + 1)).getY()) {
                        tempY = tempmegerBlock.getY();
                        tempHeight = tempmegerBlock.getHeight() + ((FreeBlock)this.freeList.get(i + 1)).getHeight();
                        this.freeList.remove(i);
                        this.freeList.remove(i);
                        this.freeList.add(new FreeBlock(tempY, tempHeight));
                        this.sortFreeList();
                        if (i == this.freeList.size() - 1) {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                } else if (this.freeList.size() == 2) {
                    tempmegerBlock = (FreeBlock)this.freeList.get(i);
                    if (tempmegerBlock.getY() + tempmegerBlock.getHeight() == ((FreeBlock)this.freeList.get(i + 1)).getY()) {
                        tempY = tempmegerBlock.getY();
                        tempHeight = tempmegerBlock.getHeight() + ((FreeBlock)this.freeList.get(i + 1)).getHeight();
                        this.freeList.remove(i);
                        this.freeList.remove(i);
                        this.freeList.add(new FreeBlock(tempY, tempHeight));
                        flag = false;
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
        }

        this.info.setText(this.freeList.toString());
    }

    public void sortFreeList() {
        for(int i = 0; i < this.freeList.size() - 1; ++i) {
            for(int j = i + 1; j < this.freeList.size(); ++j) {
                if (((FreeBlock)this.freeList.get(i)).getY() > ((FreeBlock)this.freeList.get(j)).getY()) {
                    FreeBlock temp = (FreeBlock)this.freeList.get(i);
                    this.freeList.set(i, (FreeBlock)this.freeList.get(j));
                    this.freeList.set(j, temp);
                }
            }
        }

    }

    public void drawBlock(MemeryBlock block) {
        this.sortFreeList();

        for(int i = 0; i < this.freeList.size(); ++i) {
            FreeBlock fb = (FreeBlock)this.freeList.get(i);
            if (block.getHeight() < fb.getHeight()) {
                block.setY(fb.getY());
                block.setX(0);
                block.setSize(100, block.getHeight());
                block.setBackground(Color.YELLOW);
                this.allMemery.add(block);
                this.freeList.remove(i);
                FreeBlock tempfb = new FreeBlock();
                tempfb.setY(fb.getY() + block.getHeight());
                tempfb.setHeight(fb.getHeight() - block.getHeight());
                this.freeList.add(tempfb);
                this.sortFreeList();
                break;
            }

            if (block.getHeight() == fb.getHeight()) {
                block.setY(fb.getY());
                block.setX(0);
                block.setSize(100, block.getHeight());
                block.setBackground(Color.YELLOW);
                this.allMemery.add(block);
                this.freeList.remove(i);
                break;
            }

            this.allMemery.repaint();
        }

    }

    public void mergeFreeBlock(PCBUnit pcb) {
        this.sortFreeList();

        for(int i = 0; i < this.blocks.size(); ++i) {
            MemeryBlock tempBlock = (MemeryBlock)this.blocks.get(i);
            if (tempBlock.getpId().equals(pcb.getPid())) {
                int temY = tempBlock.getY();
                int temHeight = tempBlock.getHeight();
                this.blocks.remove(tempBlock);
                this.t3.setText(this.getAllUseMemery() + "/" + 450);
                this.allMemery.remove(tempBlock);
                this.allMemery.repaint();

                for(int j = 0; j < this.freeList.size(); ++j) {
                    if (temY + temHeight == ((FreeBlock)this.freeList.get(j)).getY()) {
                        temHeight += ((FreeBlock)this.freeList.get(j)).getHeight();
                        this.freeList.remove(j);
                    }

                    try {
                        if (temY == ((FreeBlock)this.freeList.get(j)).getY() + ((FreeBlock)this.freeList.get(j)).getHeight()) {
                            temY = ((FreeBlock)this.freeList.get(j)).getY();
                            temHeight += ((FreeBlock)this.freeList.get(j)).getHeight();
                            this.freeList.remove(j);
                        }
                    } catch (Exception var8) {
                    }
                }

                this.freeList.add(new FreeBlock(temY, temHeight));
            }
        }

    }

    public int getAllUseMemery() {
        int memery = 30;

        for(int i = 0; i < this.blocks.size(); ++i) {
            memery += ((MemeryBlock)this.blocks.get(i)).getHeight();
        }

        return memery;
    }

    public void checkItem() {
        while(this.checkItems) {
            if (this.readyList.size() >= 10) {
                this.checkItems = false;
            } else if (this.waitList.size() == 0) {
                this.checkItems = false;
            } else if (this.waitList.size() > 0) {
                PCBUnit temp = (PCBUnit)this.waitList.get(0);
                MemeryBlock block = new MemeryBlock(temp.getMemery(), temp);
                this.mergeBeforButton();
                if (this.getAllUseMemery() + temp.getMemery() <= 450) {
                    this.drawBlock(block);
                    this.blocks.add(block);
                    this.t5.setText("进程名：" + temp.getPid() + "剩余时间" + temp.getTime() + "优先级：" + temp.getPri() + "所占内存：" + temp.getMemery());
                    this.t3.setText(this.getAllUseMemery() + "/" + 450);
                    this.info.setText(this.freeList.toString());
                    this.allMemery.repaint();
                    temp.setState("ready");
                    this.readyList.add(temp);
                    this.waitList.remove(0);
                    this.rePaint();
                } else {
                    this.checkItems = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Process();
                }
            });
        } catch (Exception var2) {
            throw new RuntimeException();
        }
    }

    class Action implements ActionListener {
        Action() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Process.this.randOne) {
                Process.this.t2.setText(Process.this.rand.nextInt(30) + "%");
                PCBUnit tempPCB = Process.this.randOne();
                String tempString = tempPCB.getPid();
                if (Process.this.checkPid(tempString)) {
                    Process.this.t1.setText(Integer.toString(Process.count));
                    if (Process.this.readyList.size() < 10) {
                        Process.this.block = new MemeryBlock(tempPCB.getMemery(), tempPCB);
                        Process.this.mergeBeforButton();
                        if (Process.this.getAllUseMemery() + tempPCB.getMemery() <= 450) {
                            Process.this.drawBlock(Process.this.block);
                            Process.this.blocks.add(Process.this.block);
                            Process.this.readyList.add(tempPCB);
                            Process.this.t5.setText("进程名：" + tempPCB.getPid() + "剩余时间" + tempPCB.getTime() + "优先级：" + tempPCB.getPri() + "所占内存：" + tempPCB.getMemery());
                            Process.this.info.setText(Process.this.freeList.toString());
                            Process.this.t3.setText(Process.this.getAllUseMemery() + "/" + 450);
                            Process.this.allMemery.repaint();
                            Process.this.rePaint();
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "内存溢出，未创建进程");
                            Process.count = Process.count - 1;
                            Process.this.t1.setText(Integer.toString(Process.count));
                        }
                    } else {
                        tempPCB.setState("wait");
                        Process.this.waitList.add(tempPCB);
                        Process.this.rePaint();
                    }
                } else {
                    Process.count = Process.count - 1;
                    Process.this.t1.setText(Integer.toString(Process.count));
                    JOptionPane.showMessageDialog((Component)null, "产生了重复进程名，请重新随机产生！");
                }
            } else {
                int index;
                PCBUnit temp;
                if (e.getSource() == Process.this.hold) {
                    try {
                        Process.this.t2.setText(Process.this.rand.nextInt(30) + "%");
                        index = Process.this.readyTable.getSelectedRow();
                        temp = (PCBUnit)Process.this.readyList.get(index);
                        Process.this.mergeFreeBlock(temp);
                        Process.this.mergeBeforButton();
                        Process.this.info.setText(Process.this.freeList.toString());
                        Process.this.readyList.remove(index);
                        temp.setState("hold");
                        Process.this.holdList.add(temp);
                        Process.this.rePaint();
                    } catch (Exception var15) {
                        JOptionPane.showMessageDialog((Component)null, "请选定要挂起进程！");
                    }
                } else if (e.getSource() == Process.this.holdProcess) {
                    try {
                        Process.this.t2.setText(Process.this.rand.nextInt(30) + "%");
                        index = Process.this.readyTable.getSelectedRow();
                        temp = (PCBUnit)Process.this.readyList.get(index);
                        Process.this.mergeFreeBlock(temp);
                        Process.this.mergeBeforButton();
                        Process.this.info.setText(Process.this.freeList.toString());
                        Process.this.readyList.remove(index);
                        temp.setState("hold");
                        Process.this.holdList.add(temp);
                        Process.this.rePaint();
                    } catch (Exception var14) {
                        JOptionPane.showMessageDialog((Component)null, "请选定要挂起进程！");
                    }
                } else if (e.getSource() == Process.this.stop) {
                    try {
                        Process.this.t2.setText(Process.this.rand.nextInt(10) + "%");
                        index = Process.this.readyTable.getSelectedRow();
                        temp = (PCBUnit)Process.this.readyList.get(index);
                        Process.this.mergeFreeBlock(temp);
                        Process.this.info.setText(Process.this.freeList.toString());
                        Process.this.mergeBeforButton();
                        Process.this.readyList.remove(index);
                        Process.count = Process.count - 1;
                        Process.this.t1.setText(Integer.toString(Process.count));
                        Process.this.rePaint();
                    } catch (Exception var13) {
                        JOptionPane.showMessageDialog((Component)null, "请选定要停止进程！");
                    }
                } else if (e.getSource() == Process.this.stopProcess) {
                    try {
                        Process.this.t2.setText(Process.this.rand.nextInt(10) + "%");
                        index = Process.this.readyTable.getSelectedRow();
                        temp = (PCBUnit)Process.this.readyList.get(index);
                        Process.this.mergeFreeBlock(temp);
                        Process.this.mergeBeforButton();
                        Process.this.info.setText(Process.this.freeList.toString());
                        Process.this.readyList.remove(index);
                        Process.count = Process.count - 1;
                        Process.this.t1.setText(Integer.toString(Process.count));
                        Process.this.rePaint();
                    } catch (Exception var12) {
                        JOptionPane.showMessageDialog((Component)null, "请选定要停止进程！");
                    }
                } else {
                    MemeryBlock block;
                    int i;
                    PCBUnit tempPCBx;
                    if (e.getSource() == Process.this.notify) {
                        try {
                            Process.this.t2.setText(Process.this.rand.nextInt(30) + "%");
                            if (Process.this.readyList.size() < 10) {
                                index = Process.this.holdTable.getSelectedRow();
                                temp = (PCBUnit)Process.this.holdList.get(index);
                                block = new MemeryBlock(temp.getMemery(), temp);
                                Process.this.mergeBeforButton();
                                if (Process.this.getAllUseMemery() + temp.getMemery() <= 450) {
                                    Process.this.drawBlock(block);
                                    Process.this.blocks.add(block);
                                    Process.this.allMemery.repaint();
                                    Process.this.t5.setText("进程名：" + temp.getPid() + "剩余时间" + temp.getTime() + "优先级：" + temp.getPri() + "所占内存：" + temp.getMemery());
                                    Process.this.info.setText(Process.this.freeList.toString());
                                    Process.this.t3.setText(Process.this.getAllUseMemery() + "/" + 450);
                                    Process.this.holdList.remove(index);
                                    temp.setState("ready");
                                    Process.this.readyList.add(temp);
                                    Process.this.allMemery.repaint();
                                    Process.this.rePaint();
                                } else {
                                    i = Process.this.holdTable.getSelectedRow();
                                    tempPCBx = (PCBUnit)Process.this.holdList.get(i);
                                    Process.this.holdList.remove(i);
                                    temp.setState("wait");
                                    Process.this.waitList.add(tempPCBx);
                                    Process.this.rePaint();
                                }
                            } else {
                                index = Process.this.holdTable.getSelectedRow();
                                temp = (PCBUnit)Process.this.holdList.get(index);
                                Process.this.holdList.remove(index);
                                temp.setState("wait");
                                Process.this.waitList.add(temp);
                                Process.this.rePaint();
                            }
                        } catch (Exception var11) {
                            JOptionPane.showMessageDialog((Component)null, "未选定挂起的进程或不存在挂起进程！");
                        }
                    } else if (e.getSource() == Process.this.notifyProcess) {
                        try {
                            Process.this.t2.setText(Process.this.rand.nextInt(30) + "%");
                            if (Process.this.readyList.size() < 10) {
                                index = Process.this.holdTable.getSelectedRow();
                                temp = (PCBUnit)Process.this.holdList.get(index);
                                block = new MemeryBlock(temp.getMemery(), temp);
                                Process.this.mergeBeforButton();
                                if (Process.this.getAllUseMemery() + temp.getMemery() <= 450) {
                                    Process.this.drawBlock(block);
                                    Process.this.blocks.add(block);
                                    Process.this.allMemery.repaint();
                                    Process.this.t5.setText("进程名：" + temp.getPid() + "剩余时间" + temp.getTime() + "优先级：" + temp.getPri() + "所占内存：" + temp.getMemery());
                                    Process.this.info.setText(Process.this.freeList.toString());
                                    Process.this.t3.setText(Process.this.getAllUseMemery() + "/" + 450);
                                    Process.this.holdList.remove(index);
                                    temp.setState("ready");
                                    Process.this.readyList.add(temp);
                                    Process.this.allMemery.repaint();
                                    Process.this.rePaint();
                                } else {
                                    i = Process.this.holdTable.getSelectedRow();
                                    tempPCBx = (PCBUnit)Process.this.holdList.get(i);
                                    Process.this.holdList.remove(i);
                                    temp.setState("wait");
                                    Process.this.waitList.add(tempPCBx);
                                    Process.this.rePaint();
                                }
                            } else {
                                index = Process.this.holdTable.getSelectedRow();
                                temp = (PCBUnit)Process.this.holdList.get(index);
                                Process.this.holdList.remove(index);
                                temp.setState("wait");
                                Process.this.waitList.add(temp);
                                Process.this.rePaint();
                            }
                        } catch (Exception var10) {
                            JOptionPane.showMessageDialog((Component)null, "未选定挂起的进程或不存在挂起进程！");
                        }
                    } else if (e.getSource() == Process.this.start) {
                        try {
                            Process.this.start.setEnabled(false);
                            if (Process.this.readyList.size() == 0) {
                                JOptionPane.showMessageDialog((Component)null, "无进程处于就绪队列！");
                                Process.this.start.setEnabled(true);
                            } else {
                                Thread processControl = Process.this.new ProcessControl();
                                processControl.start();
                                Process.this.start.setEnabled(false);
                            }
                        } catch (Exception var9) {
                            JOptionPane.showMessageDialog((Component)null, "无进程处于就绪或后备队列！");
                        }
                    } else if (e.getSource() == Process.this.aboutProcess1) {
                        try {
                            index = Process.this.readyTable.getSelectedRow();
                            temp = (PCBUnit)Process.this.readyList.get(index);
                            JOptionPane.showMessageDialog((Component)null, "进程：" + temp.getPid() + "优先级：" + temp.getPri() + "剩余时间：" + temp.getTime());
                        } catch (Exception var8) {
                            JOptionPane.showMessageDialog((Component)null, "进程未选中！");
                        }
                    } else if (e.getSource() == Process.this.aboutProcess2) {
                        try {
                            index = Process.this.holdTable.getSelectedRow();
                            temp = (PCBUnit)Process.this.holdList.get(index);
                            JOptionPane.showMessageDialog((Component)null, "进程：" + temp.getPid() + "优先级：" + temp.getPri() + "剩余时间：" + temp.getTime());
                        } catch (Exception var7) {
                            JOptionPane.showMessageDialog((Component)null, "进程未选中！");
                        }
                    } else if (e.getSource() == Process.this.aboutProgram) {
                        JOptionPane.showMessageDialog((Component)null, "该程序制作仓促，存在着很多不足，忘指正！");
                    } else if (e.getSource() == Process.this.exit) {
                        System.exit(1);
                    }
                }
            }

        }
    }

    class Mouse extends MouseAdapter {
        private JPopupMenu pop;

        public Mouse(JPopupMenu pop) {
            this.pop = pop;
        }

        public void maybeShowPop(MouseEvent e, JPopupMenu pop) {
            if (e.isPopupTrigger()) {
                pop.show(e.getComponent(), e.getX(), e.getY());
            }

        }

        public void mouseReleased(MouseEvent e) {
            this.maybeShowPop(e, this.pop);
        }
    }

    class ProcessControl extends Thread {
        int t;
        int pri;
        boolean flag = true;

        ProcessControl() {
        }

        public void run() {
            try {
                Process.this.checkItem();

                while(this.flag) {
                    if (Process.this.readyList.size() > 0) {
                        PCBUnit temPCB = (PCBUnit)Process.this.readyList.get(0);
                        Process.this.t4.setText("进程名：" + temPCB.getPid() + " 剩余时间：" + temPCB.getTime());
                        this.t = temPCB.getTime();
                        this.pri = temPCB.getPri();

                        try {
                            TimeUnit.MILLISECONDS.sleep(2500L);
                        } catch (Exception var3) {
                            var3.printStackTrace();
                        }

                        Process var10000 = Process.this;
                        var10000.addTime = var10000.addTime + 1;
                        if (Process.this.addTime == 10) {
                            Process.this.readyProcessAdd();
                            Process.this.rePaint();
                            Process.this.addTime = 0;
                        }

                        Process.this.checkItems = true;
                        Process.this.checkItem();
                        Process.this.t2.setText(Process.this.rand.nextInt(30) + "%");
                        --this.t;
                        temPCB.setTime(this.t);
                        --this.pri;
                        temPCB.setPri(this.pri);
                        Process.this.rePaint();
                        if (this.t <= 0) {
                            Process.this.mergeFreeBlock(temPCB);
                            Process.this.readyList.remove(temPCB);
                            Process.count = Process.count - 1;
                            Process.this.t1.setText(Integer.toString(Process.count));
                            Process.this.mergeBeforButton();
                            Process.this.rePaint();
                        }

                        if (Process.this.readyList.size() == 0 && Process.this.waitList.size() == 0) {
                            this.flag = false;
                            Process.this.rePaint();
                            Process.this.t4.setText("无进程运行！");
                            Process.this.t5.setText("无新加入进程！");
                            Process.this.start.setEnabled(true);
                        }
                    }
                }
            } catch (Exception var4) {
                JOptionPane.showMessageDialog((Component)null, "无进程处于就绪队列！");
                Process.this.start.setEnabled(true);
            }

        }
    }
}

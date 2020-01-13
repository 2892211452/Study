package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.CalendarBean;

public class CalendarPanel extends JPanel {
    JLabel labelDay[] = new JLabel[42];
    JLabel titleName[] = new JLabel[7];
    JButton button = new JButton();
    String name[] = {" Sun ", " Mon ", " Tue ", " Wed ", " Thu ", " Fri ", " Sat "};

    int year, month, dayOfMonth; // 启动程序显示的日期信息
    CalendarBean calendar;

    // 月份选择框
    JComboBox<String> MonthBox;

    // 年份显示栏
    JSpinner yearSpinner;

    public CalendarPanel(Date date) {
        this.setLayout(null);
        mouseClick mouse = new mouseClick();
        calendar = new CalendarBean();
        calendar.setYear(date.getYear());
        calendar.setMonth(date.getMonth());
        String day[] = calendar.getCalendar();
        // 获得当前日期
        dayOfMonth = date.getDate();

        JPanel pCenter = new JPanel();
        pCenter.setBounds(0, 50, 345, 240);
        pCenter.setBackground(Color.white);
        Border border = BorderFactory.createTitledBorder("calendar");
        pCenter.setBorder(border);
        this.add(pCenter);// 窗口添加在中心区域

        // 将pCenter的布局设置为7行7列的GridLayout 布局。
        pCenter.setLayout(new GridLayout(7, 7));

        // pCenter添加组件titleName[i]
        for (int i = 0; i < 7; i++) {
            titleName[i] = new JLabel(name[i], JLabel.CENTER);
            pCenter.add(titleName[i]);
        }

        Rectangle rectangle = new Rectangle(20, 20);
        // pCenter添加组件labelDay[i]
        for (int i = 0; i < 42; i++) {
            labelDay[i] = new JLabel("", JLabel.CENTER);

            labelDay[i].setBounds(rectangle);
            // 使JLabel可着色
            labelDay[i].setOpaque(true);
            labelDay[i].addMouseListener(mouse);
            pCenter.add(labelDay[i]);
        }

        int j = 0;
        for (int i = 0; i < 42; i++) {
            labelDay[i].setText(day[i]);

        }

        MonthBox = new JComboBox<String>();
        MonthBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        MonthBox.setBounds(50, 10, 81, 24);
        MonthBox.addActionListener(new MonthBox());
        initMonthBox();
        this.add(MonthBox, BorderLayout.NORTH);

        yearSpinner = new JSpinner();
        yearSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        yearSpinner.setBounds(230, 10, 81, 24);
        yearSpinner.addChangeListener(new YearSpinner());
        this.add(yearSpinner, BorderLayout.NORTH);

        // 初始化年月
        initMonthAndYear();
    }

    private void initMonthBox() {
        MonthBox.addItem("1");
        MonthBox.addItem("2");
        MonthBox.addItem("3");
        MonthBox.addItem("4");
        MonthBox.addItem("5");
        MonthBox.addItem("6");
        MonthBox.addItem("7");
        MonthBox.addItem("8");
        MonthBox.addItem("9");
        MonthBox.addItem("10");
        MonthBox.addItem("11");
        MonthBox.addItem("12");
    }

    // 监听月份栏
    class MonthBox implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            month = Integer.parseInt(MonthBox.getSelectedItem().toString());
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();

            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        }
    }

    // 监听年份栏
    class YearSpinner implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            // TODO Auto-generated method stub
            calendar.setYear(Integer.parseInt(yearSpinner.getValue().toString()));

            String day[] = calendar.getCalendar();

            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        }
    }

    void initMonthAndYear() {
        yearSpinner.setValue(Calendar.getInstance().get(Calendar.YEAR));

        month = Calendar.getInstance().get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
                MonthBox.setSelectedItem("1");
                break;
            case Calendar.FEBRUARY:
                MonthBox.setSelectedItem("2");
                break;
            case Calendar.MARCH:
                MonthBox.setSelectedItem("3");
                break;
            case Calendar.APRIL:
                MonthBox.setSelectedItem("4");
                break;
            case Calendar.MAY:
                MonthBox.setSelectedItem("5");
                break;
            case Calendar.JUNE:
                MonthBox.setSelectedItem("6");
                break;
            case Calendar.JULY:
                MonthBox.setSelectedItem("7");
                break;
            case Calendar.AUGUST:
                MonthBox.setSelectedItem("8");
                break;
            case Calendar.SEPTEMBER:
                MonthBox.setSelectedItem("9");
                break;
            case Calendar.OCTOBER:
                MonthBox.setSelectedItem("10");
                break;
            case Calendar.NOVEMBER:
                MonthBox.setSelectedItem("11");
                break;
            case Calendar.DECEMBER:
                MonthBox.setSelectedItem("12");
                break;
        }

    }

    // 对鼠标事件的监听
    class mouseClick implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 42; i++) {
                labelDay[i].setBackground(new Color(239, 239, 239));
                if (e.getComponent().equals(labelDay[i]) && labelDay[i].getText() != null) {
                    labelDay[i].setBackground(Color.GRAY);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}

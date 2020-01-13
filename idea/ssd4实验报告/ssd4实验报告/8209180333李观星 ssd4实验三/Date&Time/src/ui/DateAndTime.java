package ui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class DateAndTime extends JFrame {

    // 各面板
    private JPanel contentPane;

    private JTabbedPane tabbedPane;
    private JPanel DateAndTimePane;
    private JPanel DateAndTime_Time;
    private Border DateAndTime_TimeBorder;
    private JPanel DateAndTime_Date;
    private Border DateAndTime_DateBorder;
    private JPanel TimeZonePane;

    // AM,PM单选框
    static JRadioButton rdbtnAm;
    static JRadioButton rdbtnPm;

    // 是否更改并停止时间
    private boolean flag;

    // 数字电子时钟的三个显示栏
    private JSpinner hourSpinner;
    private JSpinner minuteSpinner;
    private JSpinner secondSpinner;

    // 获取小时，分钟，秒
    private int hourOfDay, hour, minute, second;

    // 今天的日期对象
    static GregorianCalendar now;

    // 时钟标签，上面画的是圆形时钟
    private ClockLabel clockLabel;

    // 获取年份，月份
    private int year, month;

    // 日历面板
    private CalendarPanel calendarPanel;
    // 三个按钮
    private JButton btnOk, btnCanceled, btnApply;

    // 时区选择
    private JComboBox<String> timezoneBox;
    // 时区图面板
    private JPanel timezonepanel;
    // 时区图
    private JLabel timezone;
    // 数字时钟线程
    private Thread mathticClock;

    // 时区信息数组
    private String[][] tz;
    private String[] GMT;

    private JLabel timeZoneLabel;
    // 日期
    Date date;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DateAndTime frame = new DateAndTime();
                    frame.setTitle("Data/Time");
                    frame.setFont(new Font("微软雅黑", Font.PLAIN, 15));
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DateAndTime() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 792, 580);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(0, 191, 255));
        contentPane.setLayout(null);
        // 窗口不可调
        setResizable(false);

        // 卡片布局
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        tabbedPane.setBounds(24, 43, 748, 437);
        contentPane.add(tabbedPane);

        // 处理卡片布局的第一张卡片——————————DateAndTime
        DateAndTimePane = new JPanel();
        tabbedPane.addTab("Date & Time", null, DateAndTimePane, null);
        DateAndTimePane.setLayout(null);

        // 需要先获得当前时间
        now = new GregorianCalendar();
        date = Calendar.getInstance().getTime();

        // 属于第一张卡片的右边面板TimePanel
        DateAndTime_Time = new JPanel();
        DateAndTime_Time.setBounds(402, 13, 327, 327);
        DateAndTimePane.add(DateAndTime_Time);
        DateAndTime_Time.setLayout(null);
        // 设置JPanel的标题和边框
        DateAndTime_TimeBorder = BorderFactory.createTitledBorder("Time");
        DateAndTime_Time.setBorder(DateAndTime_TimeBorder);

        // 属于第一张卡片的左边面板DatePanel
        DateAndTime_Date = new JPanel();
        DateAndTime_Date.setBounds(14, 13, 374, 327);
        DateAndTimePane.add(DateAndTime_Date);
        DateAndTime_Date.setLayout(null);
        // 设置JPanel的标题和边框
        DateAndTime_DateBorder = BorderFactory.createTitledBorder("Date");
        DateAndTime_Date.setBorder(DateAndTime_DateBorder);

        // ————————电子数字时钟的 时、分、秒位————————
        flag = true;
        hour = now.get(Calendar.HOUR_OF_DAY) - 12 > 0 ? (now.get(Calendar.HOUR_OF_DAY) - 12) : now.get(Calendar.HOUR);// 12小时制
        minute = now.get(Calendar.MINUTE);
        second = now.get(Calendar.SECOND);

        changeListen change = new changeListen();

        hourSpinner = new JSpinner();
        hourSpinner.addChangeListener(change);

        hourSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        hourSpinner.setBounds(25, 276, 54, 24);
        DateAndTime_Time.add(hourSpinner);

        minuteSpinner = new JSpinner();
        minuteSpinner.addChangeListener(change);

        minuteSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        minuteSpinner.setBounds(93, 276, 54, 24);
        DateAndTime_Time.add(minuteSpinner);

        secondSpinner = new JSpinner();
        secondSpinner.addChangeListener(change);

        secondSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        secondSpinner.setBounds(161, 276, 54, 24);
        DateAndTime_Time.add(secondSpinner);

        // ————————电子数字时钟的 时、分、秒位————————

        // 两个单选框AM/PM
        rdbtnClick rdbtnclick = new rdbtnClick();
        rdbtnAm = new JRadioButton("AM");
        rdbtnAm.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        rdbtnAm.addActionListener(rdbtnclick);
        rdbtnAm.setBounds(254, 258, 54, 27);
        DateAndTime_Time.add(rdbtnAm);

        rdbtnPm = new JRadioButton("PM");
        rdbtnPm.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        rdbtnPm.setBounds(254, 289, 54, 27);
        DateAndTime_Time.add(rdbtnPm);
        // 让其实现单选
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnAm);
        buttonGroup.add(rdbtnPm);

        // 得到当前时间
        getTime();

        // 创建一个动画时钟
        clockLabel = new ClockLabel(now);
        clockLabel.setBounds(25, 13, 258, 220);
        clockLabel.setFocusable(false);
        DateAndTime_Time.add(clockLabel);
        // 启动时钟

        // ————————————————————日历————————————————————

        calendarPanel = new CalendarPanel(date);// 14,74,346,240

        calendarPanel.setBounds(14, 24, 346, 290);

        DateAndTime_Date.add(calendarPanel);
        // ————————————————————日历————————————————————

        // 处理卡片布局的第二张卡片————————Time Zone
        TimeZonePane = new JPanel();
        tabbedPane.addTab("Time Zone", null, TimeZonePane, null);
        TimeZonePane.setLayout(null);

        // 时区
        timezoneBox = new JComboBox<String>();
        // 初始化时区
        initTimtZone();
        timezoneBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        timezoneBox.addActionListener(new timezone());
        timezoneBox.setBounds(115, 10, 495, 24);
        TimeZonePane.add(timezoneBox);

        // 时区图片
        ImageIcon image = new ImageIcon("image/GMT+12.jpg");// 图片大小：540，318 675 348

        timezonepanel = new JPanel();
        timezonepanel.setBounds(30, 40, 685, 355);
        timezonepanel.setBorder(BorderFactory.createTitledBorder(""));
        TimeZonePane.add(timezonepanel);
        timezonepanel.setLayout(null);

        timezone = new JLabel();
        timezone.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        timezone.setIcon(image);
        timezone.setBounds(5, 4, 675, 348);
        timezonepanel.add(timezone);

        // 三个按钮
        btnOk = new JButton("OK");
        btnOk.addActionListener(new btnOk());
        btnOk.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnOk.setBounds(405, 505, 113, 27);
        contentPane.add(btnOk);

        btnCanceled = new JButton("Cancel");
        btnCanceled.addActionListener(new btnCanceled());
        btnCanceled.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnCanceled.setBounds(532, 505, 113, 27);
        contentPane.add(btnCanceled);

        btnApply = new JButton("Apply");
        btnApply.addActionListener(new btnApply());
        btnApply.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnApply.setBounds(659, 505, 113, 27);
        contentPane.add(btnApply);

        // 打开窗口时获取焦点
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                btnOk.requestFocus();
            }
        });

        // 创建文字标识
        createLabel();

    }

    // 初始化时区
    private void initTimtZone() {
        tz = new String[2][50];
        tz[0][0] = "(GMT -12:00) Eniwetok, Kwajalein ";
        tz[0][1] = "(GMT -11:00) Midway Island, Samoa ";
        tz[0][2] = "(GMT -10:00) Hawaii ";
        tz[0][3] = "(GMT -09:00) Alaska ";
        tz[0][4] = "(GMT -08:00) Pacific Time (US and Canada); Tijuana ";
        tz[0][5] = "(GMT -07:00) Arizona ";
        tz[0][6] = "(GMT -07:00) Mountain Time (US and Canada) ";
        tz[0][7] = "(GMT -06:00) Central Time (US and Canada) ";
        tz[0][8] = "(GMT -06:00) Mexico City, Tegucigalpa ";
        tz[0][9] = "(GMT -06:00) Saskatchewan ";
        tz[0][10] = "(GMT -05:00) Bogota, Lima ";
        tz[0][11] = "(GMT -05:00) Eastern Time (US and Canada) ";
        tz[0][12] = "(GMT -05:00) Indiana (East) ";
        tz[0][13] = "(GMT -04:00) Atlantic Time (Canada) ";
        tz[0][14] = "(GMT -04:00) Caracas, La Paz ";
        tz[0][15] = "(GMT -03:30) Newfoundland ";
        tz[0][16] = "(GMT -03:00) Brasilia ";
        tz[0][17] = "(GMT -03:00) Buenos Aires, Georgetown ";
        tz[0][18] = "(GMT -02:00) Mid-Atlantic ";
        tz[0][19] = "(GMT -01:00) Azores, Cape Verde Is. ";
        tz[0][20] = "(GMT +00:00) Greenwich Mean Time; Dublin, Edinburgh, London, Lisbon ";
        tz[0][21] = "(GMT +00:00) Monrovia, Casablanca ";
        tz[0][22] = "(GMT +01:00) Berlin, Stockhold, Rome, Bern, Brussels, Vienna ";
        tz[0][23] = "(GMT +01:00) Paris, Madrid, Amsterdam ";
        tz[0][24] = "(GMT +01:00) Prage, Warsaw, Budapest ";
        tz[0][25] = "(GMT +02:00) Athens, Helsinki, Istanbul ";
        tz[0][26] = "(GMT +02:00) Cairo ";
        tz[0][27] = "(GMT +02:00) Eastern Europe ";
        tz[0][28] = "(GMT +02:00) Harare, Pretoria ";
        tz[0][29] = "(GMT +02:00) Israel ";
        tz[0][30] = "(GMT +03:00) Baghdad, Kuwait, Nairobi, Riyadh ";
        tz[0][31] = "(GMT +03:00) Moscow, St. Petersburgh, Kazan, Volgograd ";
        tz[0][32] = "(GMT +03:00) Tehran ";
        tz[0][33] = "(GMT +04:00) Abu Dhabi, Muscat, Tbilisi ";
        tz[0][34] = "(GMT +04:30) Kabul ";
        tz[0][35] = "(GMT +05:00) Islamabad, Karachi, Ekaterinburg, Tashkent ";
        tz[0][36] = "(GMT +05:30) Bombay, Calcutta, Madras, New Delhi, Colombo ";
        tz[0][37] = "(GMT +06:00) Almaty, Dhaka ";
        tz[0][38] = "(GMT +07:00) Bangkok, Jakarta, Hanoi ";
        tz[0][39] = "(GMT +08:00) Beijing, Chongqing, Urumqi ";
        tz[0][40] = "(GMT +08:00) Hong Kong, Perth, Singapore, Taipei ";
        tz[0][41] = "(GMT +09:00) Tokyo, Osaka, Sapporo, Seoul, Yakutsk ";
        tz[0][42] = "(GMT +09:30) Adelaide ";
        tz[0][43] = "(GMT +09:30) Darwin ";
        tz[0][44] = "(GMT +10:00) Brisbane, Melbourne, Sydney ";
        tz[0][45] = "(GMT +10:00) Guam, Port Moresby, Vladivostok ";
        tz[0][46] = "(GMT +10:00) Hobart ";
        tz[0][47] = "(GMT +11:00) Magadan, Solomon Is., New Caledonia ";
        tz[0][48] = "(GMT +12:00) Fiji, Kamchatka, Marshall Is. ";
        tz[0][49] = "(GMT +12:00) Wellington, Auckland   ";

        tz[1][0] = "image/GMT+12.jpg";
        tz[1][1] = "image/GMT-11.jpg";
        tz[1][2] = "image/GMT-10.jpg";
        tz[1][3] = "image/GMT-9.jpg";
        tz[1][4] = "image/GMT-8.jpg";
        tz[1][5] = "image/GMT-7.jpg";
        tz[1][6] = "image/GMT-7.jpg";
        tz[1][7] = "image/GMT-6.jpg";
        tz[1][8] = "image/GMT-6.jpg";
        tz[1][9] = "image/GMT-6.jpg";
        ;
        tz[1][10] = "image/GMT-5.jpg";
        tz[1][11] = "image/GMT-5.jpg";
        tz[1][12] = "image/GMT-5.jpg";
        tz[1][13] = "image/GMT-4.jpg";
        tz[1][14] = "image/GMT-4.jpg";
        tz[1][15] = "image/GMT-4.jpg";
        ;
        tz[1][16] = "image/GMT-3.jpg";
        tz[1][17] = "image/GMT-3.jpg";
        tz[1][18] = "image/GMT-2.jpg";
        tz[1][19] = "image/GMT-1.jpg";
        tz[1][20] = "image/GMT.jpg";
        tz[1][21] = "image/GMT.jpg";
        tz[1][22] = "image/GMT+1.jpg";
        tz[1][23] = "image/GMT+1.jpg";
        tz[1][24] = "image/GMT+1.jpg";
        tz[1][25] = "image/GMT+2.jpg";
        tz[1][26] = "image/GMT+2.jpg";
        tz[1][27] = "image/GMT+2.jpg";
        tz[1][28] = "image/GMT+2.jpg";
        tz[1][29] = "image/GMT+2.jpg";
        tz[1][30] = "image/GMT+3.jpg";
        tz[1][31] = "image/GMT+3.jpg";
        tz[1][32] = "image/GMT+3.jpg";
        tz[1][33] = "image/GMT+4.jpg";
        tz[1][34] = "image/GMT+4.jpg";
        tz[1][35] = "image/GMT+5.jpg";
        tz[1][36] = "image/GMT+6.jpg";
        tz[1][37] = "image/GMT+6.jpg";
        tz[1][38] = "image/GMT+7.jpg";
        tz[1][39] = "image/GMT+8.jpg";
        tz[1][40] = "image/GMT+8.jpg";
        tz[1][41] = "image/GMT+9.jpg";
        tz[1][42] = "image/GMT+10.jpg";
        tz[1][43] = "image/GMT+10.jpg";
        tz[1][44] = "image/GMT+10.jpg";
        tz[1][45] = "image/GMT+10.jpg";
        tz[1][46] = "image/GMT+10.jpg";
        tz[1][47] = "image/GMT+11.jpg";
        tz[1][48] = "image/GMT+12.jpg";
        tz[1][49] = "image/GMT+12.jpg";


        GMT = new String[50];
        GMT[0] = "GMT-12";
        GMT[1] = "GMT-11";
        GMT[2] = "GMT-10";
        GMT[3] = "GMT-9";
        GMT[4] = "GMT-8";
        GMT[5] = "GMT-7";
        GMT[6] = "GMT-7";
        GMT[7] = "GMT-6";
        GMT[8] = "GMT-6";
        GMT[9] = "GMT-6";
        GMT[10] = "GMT-5";
        GMT[11] = "GMT-5";
        GMT[12] = "GMT-5";
        GMT[13] = "GMT-4";
        GMT[14] = "GMT-4";
        GMT[15] = "GMT-3";
        GMT[16] = "GMT-3";
        GMT[17] = "GMT-3";
        GMT[18] = "GMT-2";
        GMT[19] = "GMT-1";
        GMT[20] = "GMT+0";
        GMT[21] = "GMT+0";
        GMT[22] = "GMT+0";
        GMT[23] = "GMT+1";
        GMT[24] = "GMT+1";
        GMT[25] = "GMT+2";
        GMT[26] = "GMT+2";
        GMT[27] = "GMT+2";
        GMT[28] = "GMT+2";
        GMT[29] = "GMT+2";
        GMT[30] = "GMT+3";
        GMT[31] = "GMT+3";
        GMT[32] = "GMT+3";
        GMT[33] = "GMT+4";
        GMT[34] = "GMT+5";
        GMT[35] = "GMT+5";
        GMT[36] = "GMT+6";
        GMT[37] = "GMT+6";
        GMT[38] = "GMT+7";
        GMT[39] = "GMT+8";
        GMT[40] = "GMT+8";
        GMT[41] = "GMT+9";
        GMT[42] = "GMT+10";
        GMT[43] = "GMT+10";
        GMT[44] = "GMT+10";
        GMT[45] = "GMT+10";
        GMT[46] = "GMT+10";
        GMT[47] = "GMT+11";
        GMT[48] = "GMT+12";
        GMT[49] = "GMT+12";

        for (int i = 0; i < tz[0].length; i++) {
            timezoneBox.addItem(tz[0][i]);
        }

    }

    // 时区选择框的监事件
    class timezone implements ActionListener {

        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < tz[0].length; i++) {
                if (timezoneBox.getSelectedItem().equals(tz[0][i])) {
                    TimeZone.setDefault(TimeZone.getTimeZone(GMT[i]));
                    date = Calendar.getInstance().getTime();
                    System.out.println(date);
                    timezone.setIcon(new ImageIcon(tz[1][i]));
                    timeZoneLabel.setText(tz[0][i]);
                }
            }

            // 获取当前时区时间
            year = date.getYear();
            month = date.getMonth();
            hourOfDay = date.getHours();
            minute = date.getMinutes();
            second = date.getSeconds();

            hour = (hourOfDay - 12) > 0 ? (hourOfDay - 12) : hourOfDay;
            System.out.println(hour + " " + hourOfDay);
            // 复原now 对象
            now.set(Calendar.YEAR, year);
            now.set(Calendar.MONTH, month);
            now.set(Calendar.HOUR, hour);
            now.set(Calendar.MINUTE, minute);
            now.set(Calendar.SECOND, second);

            // 复原各控件内的值
            calendarPanel.initMonthAndYear();
            hourSpinner.setValue(hour);
            minuteSpinner.setValue(minute);
            secondSpinner.setValue(second);
            if (hourOfDay > 12) {
                rdbtnPm.setSelected(true);
            } else {
                rdbtnAm.setSelected(true);
            }
        }
    }

    // AM,PM点击事件
    class rdbtnClick implements ActionListener {

        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {
            // 确定更改时间
            ClockLabel.flag = false;
            ClockLabel.clockThread.suspend();
            mathticClock.suspend();
        }

    }

    // OK按钮事件
    class btnOk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }

    }

    // cancel按钮事件
    class btnCanceled implements ActionListener {

        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {
            // 恢复到GMT+8 的北京时间
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
            date = now.getTime();

            // 恢复时区
            timezoneBox.setSelectedItem(tz[0][1]);
            timezone.setIcon(new ImageIcon(tz[1][0]));

            // 获取当前系统时间
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH);
            hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            minute = Calendar.getInstance().get(Calendar.MINUTE);
            second = Calendar.getInstance().get(Calendar.SECOND);
            hour = (hourOfDay - 12) > 0 ? (hourOfDay - 12) : hourOfDay;
            // 复原now 对象
            now.set(Calendar.YEAR, year);
            now.set(Calendar.MONTH, month);
            now.set(Calendar.HOUR, hour);
            now.set(Calendar.MINUTE, minute);
            now.set(Calendar.SECOND, second);

            // 复原各控件内的值
            calendarPanel.initMonthAndYear();
            hourSpinner.setValue(hour);
            minuteSpinner.setValue(minute);
            secondSpinner.setValue(second);

            if (hourOfDay > 12) {
                rdbtnPm.setSelected(true);
            } else {
                rdbtnAm.setSelected(true);
            }

            // 恢复线程
            ClockLabel.clockThread.resume();
            mathticClock.resume();
        }

    }

    // apply按钮事件
    class btnApply implements ActionListener {

        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            ClockLabel.flag = false;
            ClockLabel.clockThread.resume();
            mathticClock.resume();

        }
    }

    // 电子数字时钟的监听事件
    class changeListen implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

            if ((Integer) hourSpinner.getValue() >= 13) {
                hourSpinner.setValue(1);

            }
            if ((Integer) hourSpinner.getValue() <= 0) {
                hourSpinner.setValue(12);
            }
            // 设置系统时间
            now.set(Calendar.HOUR, (int) hourSpinner.getValue());

            if ((Integer) minuteSpinner.getValue() >= 60) {
                minuteSpinner.setValue(0);
                hourSpinner.setValue((Integer) (hourSpinner.getValue()) + 1);
            }
            if ((Integer) minuteSpinner.getValue() < 0) {
                minuteSpinner.setValue(59);
                hourSpinner.setValue((Integer) hourSpinner.getValue() - 1);
            }
            // 设置系统时间
            now.set(Calendar.MINUTE, (int) minuteSpinner.getValue());

            if ((Integer) secondSpinner.getValue() >= 60) {
                secondSpinner.setValue(0);
                minuteSpinner.setValue((Integer) (minuteSpinner.getValue()) + 1);
            }
            if ((Integer) secondSpinner.getValue() < 0) {
                secondSpinner.setValue(59);
                minuteSpinner.setValue((Integer) minuteSpinner.getValue() - 1);
            }
            // 设置系统时间
            now.set(Calendar.SECOND, (int) secondSpinner.getValue());
        }

    }

    // 文字标识
    void createLabel() {
        JLabel lblPonzi = new JLabel("实验三");
        lblPonzi.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblPonzi.setBounds(14, 13, 72, 18);
        contentPane.add(lblPonzi);

        JLabel lblExample = new JLabel("");
        lblExample.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblExample.setBounds(100, 13, 500, 18);
        contentPane.add(lblExample);

        JLabel lblNewLabel = new JLabel("Current Time Zone\uFF1A");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel.setBounds(14, 358, 189, 32);
        DateAndTimePane.add(lblNewLabel);

        JLabel label = new JLabel("Year");
        label.setBounds(315, 13, 72, 20);
        calendarPanel.add(label);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel label_1 = new JLabel("Month");
        label_1.setBounds(137, 13, 72, 20);
        calendarPanel.add(label_1);
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        timeZoneLabel = new JLabel(tz[0][1]);
        timeZoneLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        timeZoneLabel.setBounds(181, 359, 400, 31);
        DateAndTimePane.add(timeZoneLabel);
    }

    // 获得当前时间
    @SuppressWarnings("deprecation")
    void getTime() {
        // 设置时间
        hourSpinner.setValue((date.getHours() - 12) > 0 ? (date.getHours() - 12) : date.getHours());
        minuteSpinner.setValue(date.getMinutes());
        secondSpinner.setValue(date.getSeconds());
        // 设置当前时间是 AM 还是 PM
        if (now.get(Calendar.HOUR_OF_DAY) >= 12) {
            rdbtnPm.setSelected(true);
        } else {
            rdbtnAm.setSelected(true);
        }

        // 创建一个新线程！
        mathticClock = new MathticClock();
        mathticClock.start();

    }

    class MathticClock extends Thread {
        @Override
        public void run() {
            while (flag) {
                secondSpinner.setValue((Integer) (secondSpinner.getValue()) + 1);
                try {
                    Thread.sleep(1000);// 休眠1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

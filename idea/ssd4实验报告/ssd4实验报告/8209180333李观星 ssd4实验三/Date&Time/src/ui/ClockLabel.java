package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

//自定义时钟标签，画一个圆形的时钟
public class ClockLabel extends JLabel {
    // 时钟标签的宽度和高度
    private final int WIDTH = 300;
    private final int HEIGHT = 88 * 3;

    // 圆形时钟的X半径和Y半径
    private final int CIRCLE_X_RADIUS = 90;
    private final int CIRCLE_Y_RADIUS = 93;

    // 圆形时钟的原点
    private final int CIRCLE_X = 150;
    private final int CIRCLE_Y = 120;

    // 圆形时钟指针的长度
    private final int HOUR_LENGTH = 14 * 3;
    private final int MIN_LENGTH = 60;
    private final int SEC_LENGTH = 27 * 3;

    // 当前时针所处的角度
    double arcHour = 0;
    // 当前分针所处的角度
    double arcMin = 0;
    // 当前秒针所处的角度
    double arcSec = 0;

    // 时钟线程
    static Thread clockThread = null;

    // 是否更改了时间
    static boolean flag;

    public ClockLabel(GregorianCalendar now) {

        // 设置时钟标签的大小
        this.setSize(WIDTH, HEIGHT);

        // 获取时针、分针、秒针当前的角度
        arcHour = now.get(Calendar.HOUR) * (360.0 / 12) + now.get(Calendar.MINUTE) * (360.0 / 12 / 60)
                + now.get(Calendar.SECOND) * (360.0 / 12 / 60 / 60);
        arcMin = now.get(Calendar.MINUTE) * (360.0 / 60) + now.get(Calendar.SECOND) * (360.0 / 60 / 60);
        arcSec = now.get(Calendar.SECOND) * (360.0 / 60);
        flag = true;
        clockThread = new ClockThread();
        clockThread.start();
    }

    public void paint(Graphics g1) {
        // Graphics2D继承Graphics，比Graphics提供更丰富的方法
        Graphics2D g = (Graphics2D) g1;

        /** ***画圆形时钟的刻度，每6度便有一个刻度**** */
        for (int i = 0; i < 360; i = i + 6) {
            g.setColor(Color.gray);
            // 设置画笔的宽度为2
            g.setStroke(new BasicStroke(2));

            // 画刻度
            if (i % 90 == 0) {
                // 对于0，3，6，9点位置，使用一个大的蓝色刻度
                g.setColor(new Color(100, 149, 237));
                g.setStroke(new BasicStroke(7));// 画笔宽度为5
                // 当起点和终点一样时，画的就是点
                g.drawLine(CIRCLE_X + (int) (Math.cos(i * Math.PI / 180) * CIRCLE_X_RADIUS),
                        CIRCLE_Y + (int) (Math.sin(i * Math.PI / 180) * CIRCLE_Y_RADIUS),
                        CIRCLE_X + (int) (Math.cos(i * Math.PI / 180) * CIRCLE_X_RADIUS),
                        CIRCLE_Y + (int) (Math.sin(i * Math.PI / 180) * CIRCLE_Y_RADIUS));
            } else if (i % 30 == 0) {
                // 如果角度处于小时的位置，而且还不在0，3，6，9点时，画红色的小刻度
                g.setColor(Color.orange);
                g.setStroke(new BasicStroke(3));// 画笔宽度为3
                g.drawLine(CIRCLE_X + (int) (Math.cos(i * Math.PI / 180) * CIRCLE_X_RADIUS),
                        CIRCLE_Y + (int) (Math.sin(i * Math.PI / 180) * CIRCLE_Y_RADIUS),
                        CIRCLE_X + (int) (Math.cos(i * Math.PI / 180) * CIRCLE_X_RADIUS),
                        CIRCLE_Y + (int) (Math.sin(i * Math.PI / 180) * CIRCLE_Y_RADIUS));
            } else {
                // 其他位置就画小刻度
                g.setColor(Color.gray);
                g.drawLine(CIRCLE_X + (int) (Math.cos(i * Math.PI / 180) * CIRCLE_X_RADIUS),
                        CIRCLE_Y + (int) (Math.sin(i * Math.PI / 180) * CIRCLE_Y_RADIUS),
                        CIRCLE_X + (int) (Math.cos(i * Math.PI / 180) * CIRCLE_X_RADIUS),
                        CIRCLE_Y + (int) (Math.sin(i * Math.PI / 180) * CIRCLE_Y_RADIUS));
            }
        }

        /** ****** 画时钟的指针 ******** */
        // 画时针
        Line2D.Double lh = new Line2D.Double(CIRCLE_X, CIRCLE_Y,
                CIRCLE_X + Math.cos((arcHour - 90) * Math.PI / 180) * HOUR_LENGTH,
                CIRCLE_Y + Math.sin((arcHour - 90) * Math.PI / 180) * HOUR_LENGTH);
        // 设置画笔宽度和颜色
        g.setStroke(new BasicStroke(8));
        g.setColor(new Color(100, 149, 237));
        // 利用Graphics2D的draw方法画线
        g.draw(lh);

        // 画分针
        Line2D.Double lm = new Line2D.Double(CIRCLE_X, CIRCLE_Y,
                CIRCLE_X + Math.cos((arcMin - 90) * Math.PI / 180) * MIN_LENGTH,
                CIRCLE_Y + Math.sin((arcMin - 90) * Math.PI / 180) * MIN_LENGTH);
        g.setStroke(new BasicStroke(4));
        g.setColor(Color.orange);
        g.draw(lm);

        // 画秒针
        Line2D.Double ls = new Line2D.Double(CIRCLE_X, CIRCLE_Y,
                CIRCLE_X + Math.cos((arcSec - 90) * Math.PI / 180) * SEC_LENGTH,
                CIRCLE_Y + Math.sin((arcSec - 90) * Math.PI / 180) * SEC_LENGTH);
        g.setStroke(new BasicStroke(2));

        g.setColor(Color.lightGray);
        g.draw(ls);

    }

    class ClockThread extends Thread {

        @Override
        public void run() {

            while (true) {
                try {

                    // 获取时针、分针、秒针当前的角度
                    arcHour = DateAndTime.now.get(Calendar.HOUR) * (360.0 / 12) + DateAndTime.now.get(Calendar.MINUTE) * (360.0 / 12 / 60)
                            + DateAndTime.now.get(Calendar.SECOND) * (360.0 / 12 / 60 / 60);
                    arcMin = DateAndTime.now.get(Calendar.MINUTE) * (360.0 / 60) + DateAndTime.now.get(Calendar.SECOND) * (360.0 / 60 / 60);
                    arcSec = DateAndTime.now.get(Calendar.SECOND) * (360.0 / 60);

                    // 设置AM，PM的选择
                    APset(DateAndTime.rdbtnAm, DateAndTime.rdbtnPm);

                    // 重画时钟标签
                    repaint();

                    // 等待0.1秒钟
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void APset(JRadioButton rdbtnAm, JRadioButton rdbtnPm) {
        // 设置AM，PM的选择
        if (flag) {
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 12) {
                rdbtnPm.setSelected(true);
            } else {
                rdbtnAm.setSelected(true);
            }
        }
    }
}

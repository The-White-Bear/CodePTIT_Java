package Giaodien3;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class ClockApp extends JFrame {
    public ClockApp() {
        setTitle("PTIT CLOCK GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);

        JLayeredPane layeredPane = new JLayeredPane();
        ClockPanel clockPanel = new ClockPanel();
        DigitalClock digitalClock = new DigitalClock();

        clockPanel.setPreferredSize(new Dimension(400, 400));
        digitalClock.setPreferredSize(new Dimension(400, 30));

        layeredPane.add(clockPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(digitalClock, JLayeredPane.PALETTE_LAYER);

        clockPanel.setBounds(0, 0, 400, 400);
        digitalClock.setBounds(0, 400, 400, 30);

        add(layeredPane);
        clockPanel.startRun();
        digitalClock.startRun();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClockApp clockApp = new ClockApp();
            clockApp.setVisible(true);
        });
    }
}

class ClockPanel extends JPanel implements Runnable {
    private int hour;
    private int minute;
    private int second;
    private Thread clockThread;

    public ClockPanel() {
        setPreferredSize(new Dimension(400, 400));
        setLayout(null);
        startRun();
    }

    void startRun() {
        clockThread = new Thread(this);
        clockThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        g.setColor(Color.BLACK);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);

        for (int i = 1; i <= 12; i++) {
            int angle = i * 30;
            int x = (int) (xCenter + (clockRadius - 20) * Math.sin(Math.toRadians(angle)));
            int y = (int) (yCenter - (clockRadius - 20) * Math.cos(Math.toRadians(angle)));
            g.drawString(Integer.toString(i), x, y);
        }

        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.RED);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int) (clockRadius * 0.7);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.BLUE);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.BLACK);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    public void run() {
        while (true) {
            setCurrentTime();
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DigitalClock extends JPanel implements Runnable {
    private JLabel digitalClock;
    private JLabel dateLabel; // Thêm label cho ngày tháng năm
    private Thread clockThread;

    public DigitalClock() {
        digitalClock = new JLabel();
        digitalClock.setFont(new Font("Arial", Font.BOLD, 18));
        digitalClock.setForeground(Color.BLACK);

        dateLabel = new JLabel(); // Khởi tạo label ngày tháng năm
        dateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        dateLabel.setForeground(Color.BLACK);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(digitalClock);
        add(dateLabel); // Thêm label ngày tháng năm

        startRun();
    }

    void startRun() {
        clockThread = new Thread(this);
        clockThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void updateDigitalClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày tháng năm
        String time = timeFormat.format(new java.util.Date());
        String date = dateFormat.format(new java.util.Date()); // Lấy thông tin ngày tháng năm

        digitalClock.setText("Digital Clock: " + time);
        dateLabel.setText("| Date: " + date); // Hiển thị ngày tháng năm
    }

    @Override
    public void run() {
        while (true) {
            updateDigitalClock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

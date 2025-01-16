package vlookup.display;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vlookup.utils.Coordinate;
import vlookup.utils.StringUtil;

public class Display extends JPanel {
    private int x1, y1, x2, y2;

    public Display(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setPreferredSize(new Dimension(640, 800)); // 设置面板大小为640x480
    }

    public static void display(String line, JFrame frame) {
        int count = 0;
        if (line.length() < 8) {
            // 处理特殊情况
        } else {
            System.out.println(line);
            try {
                List<Coordinate> coordinates = StringUtil.parseCoordinates(line);
                // 如果坐标列表只有一个点
                if (coordinates.size() == 1) {
                    System.out.println(coordinates.get(0).x() + ", " + coordinates.get(0).y());
                    draw(coordinates.get(0).x(), coordinates.get(0).y(), -100, -100, frame);
                } else if (coordinates.size() >= 2) {
                    System.out.println(coordinates.get(0).x() + ", " + coordinates.get(0).y());
                    System.out.println(coordinates.get(1).x() + ", " + coordinates.get(1).y());
                    draw(coordinates.get(0).x(), coordinates.get(0).y(), coordinates.get(1).x(), coordinates.get(1).y(), frame);
                }
            } catch (Exception e) {
                System.out.println("Error parsing coordinates: " + e.getMessage());
                e.printStackTrace();  // 输出异常堆栈信息
            }
            count++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // 绘制坐标系
        g.drawLine(0, 400, 640, 400); // X轴 (中心线，y = 240)
        g.drawLine(320, 200, 320, 600); // Y轴 (中心线，x = 320)
        g2.setStroke(new BasicStroke(3.0f));
        g2.drawLine(0, 200, 640, 200); // 自定义线
        g2.drawLine(0, 600, 640, 600); // 自定义线
        String string = "Hello World!";
        String string1 = "留白";
        Font stringFont = new Font("Serif", Font.PLAIN, 50); // 使用常见字体
        g.setFont(stringFont);
        g.drawString(string, 150, 50);
        g.drawString(string1, 250, 700);

        // 如果有第二个点，绘制并标注
        if (x2 != -100 && y2 != -100) {
            g.fillOval(x2, 480 - y2, 8, 8); // 绘制第二个点
     
        }

        // 绘制第一个点
        g.fillOval(x1, 480 - y1, 8, 8); // 注意y坐标需要转换
    }

    public static void draw(int a, int b, int c, int d, JFrame frame) {
        // 坐标转换，映射到新的范围 [0, 640] 和 [0, 480]
        int newX1 = (int) ((a / 800.0) * 640);
        int newY1 = (int) (((b - 200) / 400.0) * 480);

        int newX2 = -100;
        int newY2 = -100;
        
        if (c != -100) {
            newX2 = (int) ((c / 800.0) * 640);
        }
        
        if (d != -100) {
            newY2 = (int) (((d - 200) / 400.0) * 480);
        }

        Display panel = new Display(newX1, newY1, newX2, newY2);
        frame.add(panel); // 只调用一次
        frame.pack();
        frame.setLocationRelativeTo(null); // 居中显示
        frame.setVisible(true);
    }
}

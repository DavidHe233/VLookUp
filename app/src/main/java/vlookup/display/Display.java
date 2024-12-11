package vlookup.display;

import javax.swing.*;

import vlookup.utils.Coordinate;
import vlookup.utils.StringUtil;

import java.awt.*;
import java.util.List;
public class Display extends JPanel{
    private int x1, y1, x2, y2;
    public Display(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setPreferredSize(new Dimension(800, 1200)); // 设置面板的大小
    }
    public static void ddd(String line,JFrame frame){
        int timeno=0;
        int count=0;
        if(line.length()<8){

        }else {
            System.out.println(line);
            try {
                List<Coordinate> coordinates = StringUtil.parseCoordinates(line);
                if (line.length() > 8 && line.length() < 21) {
                    System.out.println(coordinates.get(0).x()+""+coordinates.get(0).y());
                    draw(coordinates.get(0).x(),coordinates.get(0).y(), -100, -100, frame);
                } else {
                    //System.out.println(line);
                    draw(coordinates.get(0).x(),coordinates.get(0).y(), coordinates.get(1).x(),coordinates.get(1).y(), frame);
                }
            }
            catch (Exception e) {
                System.out.println("error");
            }
            count++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // 绘制坐标系
        g.drawLine(0, 400, 800, 400); // X轴
        g.drawLine(400, 200, 400, 600); // Y轴
        g2.setStroke(new BasicStroke(3.0f));
        g2.drawLine(0, 200, 800, 200);
        g2.drawLine(0, 600, 800, 600);
        String string = "Hello World!";
        String string1 = "留白";
        Font stringFont = new Font("No good", Font.PLAIN, 50);
        g.setFont(stringFont);
        g.drawString(string, 250, 100);
        g.drawString(string1, 350, 800);
        if(x2 != -100 || y2 != -100){
            g.fillOval(x2, 800 - y2, 8, 8);
            g.drawString("(" + x2 + ", " + y2 + ")", x2, 800 + y2 - 10);
        }
        g.fillOval(x1, 800 - y1, 8, 8); // 注意y坐标要转换，因为y轴向下
    }
    public static void draw(int a,int b,int c,int d,JFrame x){
        Display panel = new Display(a,b,c,d);
        x.add(panel);
        x.add(panel);
        x.pack();
        x.setLocationRelativeTo(null); // 居中显示
        x.setVisible(true);
    }
}

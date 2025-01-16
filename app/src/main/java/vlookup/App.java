package vlookup;

import java.util.List;

import javax.swing.JFrame;

import com.fazecast.jSerialComm.SerialPort;

import vlookup.display.Display;
import vlookup.utils.*;

public class App {
    public static boolean isRunning;
        public static void main(String[] args) {
         SerialPort port=IOUtil.setPort();
        JFrame frame = new JFrame("Draw Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=0;i<5;i++){
        IOUtil.readPort(port);
        }
        
        byte[] readBuffer = new byte[1024];
        int numRead = port.readBytes(readBuffer, readBuffer.length);
        for(int i=0;i<20;i++){
            numRead = port.readBytes(readBuffer, readBuffer.length);
        }
        numRead = port.readBytes(readBuffer, readBuffer.length);
                    if (numRead > 0) {
                        // 将读取到的字节转换为字符串并输出到控制台
                        String data = new String(readBuffer, 0, numRead);
                        System.out.print(data);
                        if(!data.equals(null)) {
                            Display.display(data, frame);
                        }
                        // 可以在这里添加条件来退出循环，例如读取到特定数据
                    }
        /*while (true) {
            String temp=IOUtil.readPort(port);
             System.out.print(temp);
            Display.display(temp, frame);
            Gesture.checkgesture(temp);
            System.out.println(StringUtil.parseCoordinates(IOUtil.readPort(port)).toString());
            }
            */
        
    }
}
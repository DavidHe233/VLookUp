/*
 * This source file was generated by the Gradle 'init' task
 */
package vlookup;

import javax.swing.JFrame;

import com.fazecast.jSerialComm.SerialPort;

import vlookup.display.Display;
import vlookup.utils.IOUtil;
import vlookup.utils.StringUtil;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class AppTest {
  public static void main(String[] args) {
    try{
      FileReader file=new FileReader("C:\\Users\\Zijie-Zhang\\OneDrive\\文档\\小马过河.txt");
      BufferedReader f = new BufferedReader(file);
      String line=f.readLine();
      System.out.println(line);
      JFrame frame = new JFrame("Draw Points");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                while (line!=null){
                  System.out.println(line);
                  Display.ddd(line, frame);
                  line=f.readLine();
                  try {
                    Thread.sleep(1000);
                }
                catch (Exception e){
                }
                }
    }
    catch(IOException e){
      System.out .println("file not found");
    }
    /*SerialPort port=IOUtil.setPort();
        JFrame frame = new JFrame("Draw Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IOUtil.readPort(port);
        IOUtil.readPort(port);IOUtil.readPort(port);IOUtil.readPort(port);IOUtil.readPort(port);IOUtil.readPort(port);IOUtil.readPort(port);
        while (true) {
        String temp=IOUtil.readPort(port);
      System.out.print(temp);
        Display.ddd(temp, frame);;
        System.out.println(StringUtil.parseCoordinates(IOUtil.readPort(port)).toString());
        }
        */

  }
  
}

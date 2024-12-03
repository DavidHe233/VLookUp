package vlookup.utils;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class IOUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static SerialPort setPort() {
        SerialPort port = null;
        while (port == null) {
            System.out.print("Enter port name: ");
            String portName = scanner.nextLine();
            SerialPort[] commPorts = SerialPort.getCommPorts();
            for (SerialPort commPort : commPorts) {
                if (commPort.getSystemPortName().equals(portName)) {
                    port = commPort;
                    break;
                }
            }
            if (port == null) {
                System.out.println("Port not found");
            }
        }
        System.out.println("Selected port: " + port.getSystemPortName());
        return port;
    }
}

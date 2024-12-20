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
        port.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        if (!port.openPort())
            throw new RuntimeException("Failed to open port");
        return port;
    }
}

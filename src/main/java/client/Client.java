package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static final String HOST = "127.0.0.1";
    private final int port;

    public Client(int port) {
        this.port = port;
    }

    public void start() {
        IOInterfase interfase = new UserConsoleInput();
        String inputStr = interfase.getUserInput();
        try (
                Socket socket = new Socket(HOST, this.port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            while (!inputStr.equals("end")) {
                if (inputIsInteger(inputStr, interfase)) {
                    out.println(inputStr);
                    interfase.printMessage(in.readLine());
                }
                inputStr = interfase.getUserInput();
            }
            interfase.printMessage("Пока");
            out.println(inputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        interfase.printMessage("Клиент завершил работу");
    }

    private boolean inputIsInteger(String inputStr, IOInterfase interfase) {
        try {
            Integer.parseInt(inputStr);
            return true;
        } catch (Exception e) {
            interfase.printMessage("Не корректное значение");
            return false;
        }
    }
}
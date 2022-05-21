package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private final int port;

    public MyServer(int port) {
        this.port = port;
    }

    public void start() {
        try (
                ServerSocket serverSocket = new ServerSocket(this.port);
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            FibCalculator calculator = new FibCalculator();
            while (true) {
                String inputStr = in.readLine();
                if (inputStr == null || inputStr.equals("end")) break;
                out.println(calculator.getFibValue(Integer.parseInt(inputStr)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сервер завершил работу");
    }
}

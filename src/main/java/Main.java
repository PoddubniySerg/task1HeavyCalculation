import client.Client;
import server.MyServer;

public class Main {
    private final static int PORT = 8080;

    public static void main(String[] args) {
        new Thread(() -> new MyServer(PORT).start(), "Server").start();
        new Thread(() -> new Client(PORT).start(), "Client").start();
    }
}

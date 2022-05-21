package client;

import java.util.Scanner;

public class UserConsoleInput implements IOInterfase {

    @Override
    public String getUserInput() {
        System.out.print("Введите 'end' для окончания программы или целое число: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
        System.out.println();
    }
}

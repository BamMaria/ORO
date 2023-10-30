package com.LR_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Connection {
    private Socket clientSocket;

    public Connection(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        int num1, num2, result, remainder;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            num1 = Integer.parseInt(reader.readLine());
            System.out.print("Получено делимое: " + num1);

            num2 = Integer.parseInt(reader.readLine());
            System.out.print("Получен делитель: " + num2);
            System.out.println();
            if (num2 != 0) {
                result = num1 / num2;
                System.out.println("Частное: " + result);

                remainder = num1 % num2;
                System.out.println("Остаток: " + remainder);

                writer.write(result + "\n");
                writer.write(remainder + "\n");
            } else {
                String response = "Ошибка! Деление на ноль";
                System.out.println(response);

                writer.write(response + "\n");
            }
            writer.flush();
            System.out.println();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}

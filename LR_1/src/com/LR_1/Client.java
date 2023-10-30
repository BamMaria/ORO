package com.LR_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        int num1, num2, result, remainder;

        Socket clientSocket = new Socket("127.0.0.1", 8080);
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        BufferedReader keyboardReader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Введите делимое: ");
        num1 = Integer.parseInt(keyboardReader.readLine());

        System.out.print("Введите делитель: ");
        num2 = Integer.parseInt(keyboardReader.readLine());
        System.out.println();

        writer.write(num1 + "\n");
        writer.write(num2 + "\n");
        writer.flush();

        try {
            result = Integer.parseInt(reader.readLine());
            remainder = Integer.parseInt(reader.readLine());

            System.out.println("Частное: " + result);
            System.out.println("Остаток: " + remainder);
            System.out.println();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        keyboardReader.close();
        reader.close();
        writer.close();
        clientSocket.close();
    }
}

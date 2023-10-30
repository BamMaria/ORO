package com.LR_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static BufferedReader keyboardReader = new BufferedReader(
            new InputStreamReader(System.in));

    private Client() {}
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(8080);
            PointRemote stub = (PointRemote) registry.lookup("PointRemote");

            Point p1 = getPoint();
            Point p2 = getPoint();

            System.out.println("Точка 1: " + p1 + ", точка 2: " + p2);
            System.out.println("Длина отрезка между точками: " + stub.getSegmentLength(p1, p2));
            System.out.println("Длина окружности, центром которой является одна из точек, а радиусом - расстояние между точками: " + stub.getCircleLength(p1, p2));
            System.out.println("Площадь круга, центром которого является одна из точек, а радиусом - расстояние между точками:  " + stub.getCircleArea(p1, p2));
            System.out.println("Длина окружности, диаметром которой является расстояние между точками: " + stub.getCircleLengthByDiameter(p1, p2));
            System.out.println("Площадь круга, диаметром которого является расстояние между точками: " + stub.getCircleAreaByDiameter(p1, p2));

            keyboardReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private static Point getPoint() throws IOException {

        System.out.println("Введите координаты точки: ");
        System.out.print("x = ");
        double x = Double.parseDouble(keyboardReader.readLine());

        System.out.print("y = ");
        double y = Double.parseDouble(keyboardReader.readLine());

        Point p = new Point(x, y);
        System.out.println("-----------------");
        return p;
    }
}

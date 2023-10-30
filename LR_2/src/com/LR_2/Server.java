package com.LR_2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {

            PointRemoteImpl pointRemoteImpl = new PointRemoteImpl();
            PointRemote stub = (PointRemote) UnicastRemoteObject.exportObject(pointRemoteImpl, 0);

            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("PointRemote", stub);

            System.out.println("Сервер готов");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

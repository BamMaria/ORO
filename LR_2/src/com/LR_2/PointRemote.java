package com.LR_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PointRemote extends Remote{

        double getSegmentLength(Point p1, Point p2) throws RemoteException;

        double getCircleLength(Point centerPoint, Point radiusPoint) throws RemoteException;

        double getCircleArea(Point centerPoint, Point radiusPoint) throws RemoteException;

        double getCircleLengthByDiameter(Point p1, Point p2) throws RemoteException;

        double getCircleAreaByDiameter(Point p1, Point p2) throws RemoteException;

}

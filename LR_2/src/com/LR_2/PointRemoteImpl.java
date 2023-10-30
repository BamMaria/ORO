package com.LR_2;

import java.rmi.RemoteException;
import static java.lang.Math.*;

public class PointRemoteImpl implements PointRemote{
    public PointRemoteImpl() throws RemoteException{

    }
    @Override
    public double getSegmentLength(Point p1, Point p2) throws RemoteException {
        return sqrt(pow(p2.getX() - p1.getX(), 2) + pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public double getCircleLength(Point centerPoint, Point radiusPoint) throws RemoteException {
        return 2 * PI * getSegmentLength(centerPoint, radiusPoint);
    }

    @Override
    public double getCircleArea(Point centerPoint, Point radiusPoint) throws RemoteException {
        return PI * pow(getSegmentLength(centerPoint, radiusPoint), 2);
    }

    @Override
    public double getCircleLengthByDiameter(Point p1, Point p2) throws RemoteException {
        return PI * getSegmentLength(p1, p2);
    }

    @Override
    public double getCircleAreaByDiameter(Point p1, Point p2) throws RemoteException {
        return PI * (getSegmentLength(p1, p2) * getSegmentLength(p1, p2) / 4);
    }
}

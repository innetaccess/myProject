package com.javarush.test.level32.lesson10.home01.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoubleString extends Remote
{
    public String doubleString(String str) throws RemoteException;
}


package main;

public interface Farmer extends java.rmi.Remote {
    public Object compute()
        throws java.rmi.RemoteException;
}
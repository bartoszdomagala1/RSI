package main;

public interface Worker extends java.rmi.Remote {
    public Object compute(Task task, Object params)
        throws java.rmi.RemoteException;
}

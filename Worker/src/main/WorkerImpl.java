package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WorkerImpl extends java.rmi.server.UnicastRemoteObject implements Worker {


    private static final long serialVersionUID=101L;

	public WorkerImpl() throws java.rmi.RemoteException {
		super();
	}

	public Object compute(Task task, Object params) throws java.rmi.RemoteException {
		//System
		return task.compute(params);
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Podaj uchwyt RMI");
			return;
		}
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new java.rmi.RMISecurityManager());
		}
		 System.out.println(args[0]);
		 System.out.println(args[1]);
		 int o=Integer.parseInt(args[1]);
		
		try {
			Registry reg;
			reg = LocateRegistry.createRegistry(o);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		

		try {
			WorkerImpl instance = new WorkerImpl();
			java.rmi.Naming.rebind(args[0], instance);
			System.out.println("Worker gotowy.");
		} catch (Exception e) {
			System.out.println("server nie moze byc zarejestrowany");
	           
			e.printStackTrace();
			return;
		}
	}
}
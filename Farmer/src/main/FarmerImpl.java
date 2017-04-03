package main;

import java.rmi.RemoteException;
import java.util.*;

public class FarmerImpl extends java.rmi.server.UnicastRemoteObject implements Farmer {

	private Worker[] workers;

	public FarmerImpl(String[] args) throws java.rmi.RemoteException, Exception {
		super();
		int i;
		workers = new Worker[args.length - 1];
		for (i = 1; i < args.length; i++) {
			try {
				workers[i - 1] = (Worker) java.rmi.Naming.lookup(args[i]);
			} catch (Exception e) {
				throw e;
			}
		}

		

		// System.out.println(workers.length+"uuuu");
		Vector v=(Vector)compute();
		

		for (i = 1; i < v.size(); i++) {

			System.out.println(v.get(i));
		}
	}
//tworzy obiekty -zadanie
	public java.util.Vector splitParams(Object params, int howManySubtasks) {

		// podzial na zadania
		java.util.Vector subtasks = new java.util.Vector();
		java.util.Vector params1 = (java.util.Vector) params;

		int poczWart = ((Integer) params1.get(0));// 1
		int konWart = ((Integer) params1.get(1));// 400

		int przedzial = konWart / howManySubtasks;
		int i;
		for (i = 0; i < howManySubtasks; i++) {
			
			int min = i * przedzial + 1;
			int max = (i + 1) * przedzial;

			java.util.Vector subtask = new java.util.Vector();
			subtask.add(new Integer(min));
			subtask.add(new Integer(max));
			subtasks.add(subtask);
		}
		return subtasks;
	}

	public Object combineResults(java.util.Vector partialResults) {
		int i;

		java.util.Vector result = new Vector();

		for (i = 0; i < partialResults.size(); i++) {
			result.addAll((Vector) partialResults.get(i));

		}
		return result;
	}

	@Override
	public Object compute() throws java.rmi.RemoteException {

		/*
		 * poczatek zadania pocztkowy przedzial do wyszukiwania liczby pierwszej
		 * 1-300
		 */
		Vector param = new Vector();
		param.addElement(1);
		param.addElement(400);
		PrimeNumberTask task = new PrimeNumberTask();

		Vector results = new Vector();

		Vector subtasks;

		subtasks = splitParams(param, workers.length);
		int i;
		for (i = 0; i < workers.length; i++) {
			System.out.println(i + " dlugosc wol");
			results.add(workers[i].compute(task, subtasks.get(i)));
		}

		return combineResults(results);
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Podaj uchwyt farmera i co najmniej jeden uchwyt workera.");
			return;
		}
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new java.rmi.RMISecurityManager());
		try {
			FarmerImpl instance = new FarmerImpl(args);
			java.rmi.Naming.rebind(args[0], instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Farmer gotowy.");
	}

}
package main;


/**
 * Interface Farmera
 * @author Bartosz Domagala, 220945
 */
public interface Farmer extends java.rmi.Remote {
    /**
     * Metoda, ktora farmer bedzie wykonywal z uzyciem workerow
     * @return - Wynik obliczen
     * @throws java.rmi.RemoteException - Wyjatek podczas pracy ze zdalnym obiektem
     */
    public Object compute()
            throws java.rmi.RemoteException;
}
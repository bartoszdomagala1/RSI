package main;

/**
 * Interface workera
 * @author Bartosz Domagala, 220945
 */
public interface Worker extends java.rmi.Remote {
    /**
     * Metoda wykonujaca otrzymane zadanie
     * @param task - zadanie do wykonania
     * @param params - lista parametrow zadania
     * @return - Wynik wykonania otrymanego zaadania
     * @throws java.rmi.RemoteException - wyjatek wykonania obiektu zdalnego
     */
    public Object compute(Task task, Object params)
            throws java.rmi.RemoteException;
}
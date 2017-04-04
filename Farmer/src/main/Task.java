package main;
/**
 * Interface sluzacy do przekazywania typu zadania do workera
 * @author Bartosz Domagala, 220945
 */
public interface Task extends java.io.Serializable {
    /**
     * Metoda rozwiazujaca zadanie
     * @param args - parametry metody(rozne zaleznie od implementacji)
     * @return - Zwraca wynik obliczen
     */
    public Object compute(Object args);
}
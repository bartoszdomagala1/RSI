package main;

public interface Task extends java.io.Serializable {
    public Object compute(Object args);
}
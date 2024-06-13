package uy.edu.um.prog2.adt.linkedlist;

public class Node<T extends Comparable<T>> {

    private T value;

    private Node<T> next;

    private int priority;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean menorque(Node<T> menor){ return this.getValue().compareTo(menor.getValue())<0; }

    public boolean mayorque(Node<T> menor){ return this.getValue().compareTo(menor.getValue())>0; }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

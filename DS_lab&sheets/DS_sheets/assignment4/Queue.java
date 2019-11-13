package app;

import java.util.*;

class Queue<T> {
    private LinkedList<T> l;

    public Queue(){
        l = new LinkedList<T>();
    }

    public void push(T value) {
        l.addLast(value);
    }

    public T pop() {
        return l.removeFirst();
    }

    public T front() {
        return l.getFirst();
    }

    public boolean isEmpty() {
        return l.isEmpty();
    }

    public int size() {
        return l.size();
    }
}

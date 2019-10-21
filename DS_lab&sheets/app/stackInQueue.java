package app;

import java.util.Collection;

class stackInQueue<T> {
    private Queue<T> q;

    public stackInQueue(){
        q = new Queue<T>();
    }

    public void push(T value) {
        q.push(value);
    }

    public T pop() {
        for (int i = 0; i < q.size()-1; i++) {
            q.push(q.pop());
        }
        return q.pop();
    }

    public T peek() {
        for (int i = 0; i < q.size()-1; i++) {
            q.push(q.pop());
        }
        T temp = q.front();
        q.push(q.pop());
        return temp;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

}

package app;

import java.util.*;
class queueIn2stacks<T>{
    Stack<T> s1=new Stack<T>();
    Stack<T> s2=new Stack<T>();
    public void enqueue(T value) {
        s1.push(value);
    }
    public T dequeue() {
        int n=s1.size();
        for (int i = 0; i < n; i++) {
            s2.push(s1.pop());
        }
        T temp = s2.pop();
        for (int i = 0; i < s2.size(); i++) {
            s1.push(s2.pop());
        }
        return temp;
    }
}
import java.util.*;

public class QueueToStack<T> {
    private Queue<T> q = new LinkedList<>();


    public void push(T value) {
        q.add(value);
    }

    public T pop() {
        for (int i = 0; i < q.size()-1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public T peek() {
        for (int i = 0; i < q.size()-1; i++) {
            q.add(q.remove());
        }
        T temp = q.peek();
        q.add(q.remove());
        return temp;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
    public int size(){
        return q.size();
    }
    public static void main(String args[]){
        QueueToStack<Integer> stack = new QueueToStack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

import java.util.Stack;

public class StackToQueue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public void enqueue(T data){
        s1.push(data);
    }

    public T dequeue(){
        if(s1.empty())
            return null;
        while(s1.size()>1)
            s2.push(s1.pop());
        T temp = s1.pop();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return (T) temp;
    }
    public static void main(String [] args){
        StackToQueue<Integer> queue = new StackToQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

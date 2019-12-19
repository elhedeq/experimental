import java.util.*;

public class CopyQueueReversed {
    public static int queueSize,sz;
    public static void copyAndReverseQueue(Queue queue1, Queue queue2){
        if(sz == queueSize)
            return;
        Object t = queue1.remove();
        queue1.add(t);
        sz++;
        copyAndReverseQueue(queue1, queue2);
        queue2.add(t);
    }
    public static void main(String args[]){
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        queueSize = queue1.size();

        copyAndReverseQueue(queue1, queue2);

        while(queue1.size() > 0)
            System.out.println(queue1.remove());
        System.out.println("_____________________________");
        while(queue2.size() > 0)
            System.out.println(queue2.remove());
    }
}

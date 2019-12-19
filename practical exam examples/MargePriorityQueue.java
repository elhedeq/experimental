import java.util.Iterator;
import java.util.PriorityQueue;

public class MargePriorityQueue {


    public static void main(String [] args){
        PriorityQueue<Integer> qu1 = new PriorityQueue<>();
        PriorityQueue<Integer> qu2 = new PriorityQueue<>();
        qu1.add(1);
        qu2.add(2);
        qu1.add(3);
        qu2.add(4);
        while(!qu2.isEmpty())
            qu1.add(qu2.remove());
        Iterator<Integer> it = qu1.iterator();
        while (!qu1.isEmpty())
            System.out.println(qu1.remove());
    }

}

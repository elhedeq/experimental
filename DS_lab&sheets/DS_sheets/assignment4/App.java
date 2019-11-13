package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        //testing dequeue
        System.out.println("Dequeue");
        Dequeue_doublyList dq = new Dequeue_doublyList();
        for (int i = 1; i <= 10; i++) {
           dq.push_front(i);
           dq.push_back(i+10);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(dq.pop_front()+" ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
           System.out.print(dq.pop_back()+" ");
        }
        System.out.println();
       
        //testing reverse method
        System.out.println("reversing queue");
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 1; i <= 10; i++) {
           q.push(i);
        }
        q=reverse(q);
        for (int i = 0; i < 10; i++) {
           System.out.println(q.pop());
        }

        //testing stackIn2Qs
        System.out.println("stack in 2 queues");
        stackIn2Qs<Integer> stk = new stackIn2Qs<Integer>();
        for (int i = 1; i <= 10; i++) {
            stk.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(stk.pop()+" ");
        }
        System.out.println();

        //testing queueIn2stacks
        System.out.println("queue in 2 stacks");
        queueIn2stacks<Integer> q2 = new queueIn2stacks<Integer>();
        for (int i = 1; i <= 10; i++) {
            q2.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(q2.dequeue()+" ");
        }
        System.out.println();
    }

    public static Queue reverse(Queue q) {
        Stack<Object> stk = new Stack<Object>();
        while (!q.isEmpty()) {
            stk.push(q.pop());
        }
        while (!stk.isEmpty()) {
            q.push(stk.pop());
        }
        return q;
    }
}
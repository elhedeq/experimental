import java.util.*;

public class CopyStack {
    public static void copyStack(Stack stack1, Stack stack2){
        if(stack1.empty())
            return;
        Object t = stack1.pop();
        copyStack(stack1, stack2);
        stack1.push(t);
        stack2.push(t);
    }
    public static void main(String args[]){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        copyStack(stack1,stack2);

        while(!stack1.empty())
            System.out.println(stack1.pop());
        System.out.println("_____________________________");
        while(!stack2.empty())
            System.out.println(stack2.pop());
    }
}

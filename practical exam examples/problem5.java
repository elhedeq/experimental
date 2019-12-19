package app;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
	//you have to enter only one character each time
	//to print the first non-repeating character type #
	//to exit type 0
        Queue<Character> q = new LinkedList<Character>();
        String str = new String();
        Scanner scan = new Scanner(System.in);
        char ch = '\0';
        while (ch != '0'){
            ch = scan.next().charAt(0);
            if (ch == '#'){
                System.out.println("\n first non-repeating character: "+q.peek());
                continue;
            }
            if (str.contains(String.valueOf(ch)))
                removChar(ch, q);
            else
                q.add(ch);
            str += ch;
        }
        
    }

    public static void removChar(char ch, Queue<Character> q) {
        Queue<Character> temp = new LinkedList<Character>();
        while(q.peek() != ch)
            temp.add(q.remove());
        q.remove();
        while(q.size() > 0)
            temp.add(q.remove());
        while(temp.size() > 0)
            q.add(temp.remove());
    }

}

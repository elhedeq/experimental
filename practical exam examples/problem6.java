package app;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
	//you have to enter only one character each time
	//to print the first non-repeating character type #
	//to exit type 0
        Stack<Character> stk = new Stack<Character>();
        String str = new String();
        Scanner scan = new Scanner(System.in);
        char ch = '\0';
        while (ch != '0'){
            ch = scan.next().charAt(0);
            if (ch == '#'){
                System.out.println("\n first non-repeating character: "+getFirst(stk));
                continue;
            }
            if (str.contains(String.valueOf(ch)))
                removChar(ch, stk);
            else
                stk.add(ch);
            str += ch;
        }
    }

    public static char getFirst(Stack<Character> stk) {
        Stack<Character> tempStk = new Stack<Character>();
        while (stk.size()>1) {
            tempStk.push(stk.pop());
        }
        char tempCh = stk.pop();
        tempStk.push(tempCh);
        while (tempStk.size()>0) {
            stk.push(tempStk.pop());
        }
        return tempCh;
    }

    public static void removChar(char ch, Stack<Character> stk) {
        Stack<Character> tempStk = new Stack<Character>();
        char tempCh = stk.pop();
        while(tempCh != ch){
            tempStk.push(tempCh);
            tempCh = stk.pop();
        }
        while(stk.size() > 0)
            tempStk.push(stk.pop());
        while(tempStk.size() > 0)
            stk.push(tempStk.pop());
    }

}

package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("128: "+decimalToBinary(128)+" "+decimalToBase(128, 8)+" "+decimalToBase(128, 16));
        //testing dualstack class
        dualStack twoStack = new dualStack(100);
        for (int i = 1; i <= 10; i++) {
            twoStack.push1(i);
            twoStack.push2(i+10);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(twoStack.pop1()+" ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(twoStack.pop2()+" ");
        }
        System.out.println();
    }

    public static String decimalToBinary(int num) {
        String result = "";
        Stack<Integer> stk = new Stack<Integer>();
        while (num>0) {
            stk.push((int)num%2);
            num /=2;
        }
        while (!stk.isEmpty()) {
            result +=stk.pop();
        }
        return result;
    }

    public static String decimalToBase(int num, int base) {
        Stack<Integer> stk = new Stack<Integer>();
        String result = "";
        while (num>0) {
            stk.push((int)num%base);
            num /=base;
        }
        while (!stk.isEmpty()) {
            result +=convert(stk.pop(), base);
        }
        return result;
    }

    public static String convert(long value, int base) {
        int mod = (int)value%base;
        if (mod>9)
            return String.valueOf((char)('A'+mod-10));
        return String.valueOf(mod);
    }

}
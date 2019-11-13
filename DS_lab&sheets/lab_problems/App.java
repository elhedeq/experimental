package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("reversed: "+printBackward("hello world!"));
        System.out.println("214\tbase2:"+baseConvert(214, 2)+"\tbase8: "+baseConvert(214, 8)+"\tbase16: "+baseConvert(214, 16));
        System.out.print("35 in binary: ");
        binaryConvert(35);
    }

    public static String printBackward(String word) {
        if (word.length()<=1)
            return word;
        return word.charAt(word.length()-1)+printBackward(word.substring(0, word.length()-1));
    }
    
    public static void binaryConvert(long value) {
        Stack<Integer> stk = new Stack<Integer>();
        while (value>0) {
            stk.push((int)value%2);
            value /=2;
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop());
        }
        System.out.println();
    }

    public static String convert(long value, int base) {
        int mod = (int)value%base;
        if (mod>9)
            return String.valueOf((char)('A'+mod-10));
        return String.valueOf(mod);
    }

    public static String baseConvert(long value, int base) {
        if (value==0)
            return "";
        return baseConvert(value/base, base)+convert(value, base);
    }

}
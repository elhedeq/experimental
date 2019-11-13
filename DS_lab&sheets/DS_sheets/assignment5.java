package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //testing reverseDisplay method
        System.out.println("Enter a word");
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        System.out.println(reverseDisplay(word));
        //testing dec2Bin method
        System.out.println("Enter a decimal number");
        int n = scan.nextInt();
        System.out.println(n+" in binary "+dec2Bin(n));
    }

    public static String reverseDisplay(String value) {
        if (value.length()<=1)
            return value;
        return value.charAt(value.length()-1)+reverseDisplay(value.substring(0, value.length()-1));
    }

    public static String dec2Bin(int value) {
        if (value==0)
            return "";
        return dec2Bin(value/2)+value%2;
    }

}
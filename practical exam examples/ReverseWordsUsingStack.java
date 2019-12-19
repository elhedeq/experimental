import java.util.*;

public class ReverseWordsUsingStack {
    public static String reverseWords(String string){
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == ' ' || i == string.length()-1){
                stringBuilder.append(string.charAt(i));
                if(i == string.length()-1)
                    stringBuilder.append(" ");
                stack.push(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }else{
                stringBuilder.append(string.charAt(i));
            }
        }
        stringBuilder.delete(0, stringBuilder.length());
        while(!stack.empty())
            stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }

    public static void main(String args[]){
        String string = "hello every body";
        System.out.println(string);
        string = reverseWords(string);
        System.out.println(string);
    }
}

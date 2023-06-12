package src.Easy;

import java.util.*;

public class ValidParanthesis {

    public static void main(String[] args) {
        String s = "";
        System.out.println(isValid("([]{})"));
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    static boolean isValid1(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (final char c : s.toCharArray())
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // iterate throught the string s
        // and store each char in a stack
        // if the stack.peek is not the closing the current one
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(c == ')'){
                if(stack.peek() != '('){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }else if(c == ']'){
                if(stack.peek() != '['){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }else if(c == '}'){
                if(stack.peek() != '{'){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}

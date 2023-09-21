package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class L227_BAsicCalc {
    public static void main(String[] args) {
        String input = "(3*2)";
        System.out.print(calculate(input));
    }

    public static int calculate(String s) {
        int ans = 0;
        int currNum = 0;
        int prevNum = 0;
        char op = '+';
        for (int j = 0; j < s.length(); j++) {
            final char c = s.charAt(j);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (!Character.isDigit(c) && c != ' ' || j == s.length() - 1) {
                if (op == '+' || op == '-') {
                    ans += prevNum;
                    prevNum = op == '+' ? currNum : -currNum;
                } else if (op == '*') {
                    prevNum *= currNum;
                } else if (op == '/') {
                    prevNum /= currNum;
                }
                op = c;
                currNum = 0;
            }
        }
        return ans + prevNum;
    }

    static char getIndexOf(String string) {
        char c = '0';
        if (string.indexOf('(') >= 0) {
            return '(';
        } else if (string.indexOf('/') >= 0) {
            return '/';
        } else if (string.indexOf('*') >= 0) {
            return '*';
        } else if (string.indexOf('-') >= 0) {
            return '-';
        } else {
            return '+';
        }
    }

    private static int calculate(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        throw new IllegalArgumentException();
    }

    public int calculate1(String s) {
        Deque<Integer> numbs = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    ++i;
                }
                numbs.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && compare(ops.peek(), c))
                    numbs.push(calculate(ops.pop(), numbs.pop(), numbs.pop()));
                ops.push(c);
            }
        }

        while (!ops.isEmpty())
            numbs.push(calculate(ops.pop(), numbs.pop(), numbs.pop()));

        return numbs.peek();
    }


    private static boolean compare(char op1, char op2) {
        return op1 == '*' || op1 == '/' || op2 == '+' || op2 == '-';
    }
}

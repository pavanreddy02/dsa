package Medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class L91_DecodeWays {
    public static void main(String[] args) {
        numDecodings("ss");
    }

    public static int numDecodings(String s) {
        int ans = 0;
        var ll = new ArrayDeque<>();
        Stack<Integer> ss = new Stack<>();
        for(int i =0; i< s.length();i++){

            ss.push(i);
        }
        return ans;
    }
}

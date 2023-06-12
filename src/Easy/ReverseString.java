package Easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        String [] s1 = {"h","e","l","l","o"};
        List<String> l1 = new ArrayList<>(Arrays.asList(s1));
        Collections.reverse(l1);
//        System.out.println(DsaUtility.reverseString(s));
//        System.out.println(reverse(s));
        usingSwapReverseString(s1);
        System.out.println(Arrays.toString(s1));
    }

    static String reverse(String s) {
        StringBuilder o = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            o.append(s.charAt(i));
        }
        return o.toString();
    }

    static void usingSwapReverseString(String [] s){
        int l = 0;
        int r = s.length-1;
        while (l<r){
            String temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}

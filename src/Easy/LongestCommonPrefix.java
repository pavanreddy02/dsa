package Easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flowerd","flowerb","floweraddddddd","flowerc"};
        longestCommonPrefix(input);
       /*
        StringBuilder prefix = new StringBuilder();
        String ans = "";

        String temp = input[0];
        for (int j = 1; j < Math.min(input.length, temp.length()); j++) {
            prefix.append(temp.charAt(j - 1));
            if (input[j].startsWith(prefix.toString())) {
                if (j == input.length - 1) ans = prefix.toString();
            } else break;
        }

        System.out.println(ans);
        if (ans.equalsIgnoreCase("")) System.out.println("There is no common prefix among the input strings.");
        */
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}

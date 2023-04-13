package src.Medium;

import src.Util.DsaUtility;

import java.util.ArrayList;
import java.util.List;

public class L131_PalindromePartition {
    public static void main(String[] args) {
        String input = "a";
        System.out.println(partition(input));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (sub.equalsIgnoreCase(DsaUtility.reverseString(sub)) && sub.length() > 1) {
                list.add(sub);
            }
        }
        if (s.length() > 1) {
            if (s.charAt(s.length() - 1) != s.charAt(s.length() - 2))
                list.add(String.valueOf(s.charAt(s.length() - 1)));
        }
        if (list.size() > 0) {
            ans.add(list);
        }
        ans.add(new ArrayList<>(s.chars().mapToObj(c -> String.valueOf((char) c)).toList()));
        return ans;
    }
}

//         List<String> myList = s.chars().mapToObj(c -> String.valueOf((char) c)).toList();



package Medium;


import Util.DsaUtility;

import java.util.ArrayList;
import java.util.List;

public class L131_PalindromePartition {
    public static void main(String[] args) {
        String input = "a";
        System.out.println(partition1(input));
    }

    static List<List<String>> partition1(String s) {
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
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        dfs(result, new ArrayList<>(), s, isPalindrome, 0);
        System.out.println();
        return result;
    }



    private void dfs(List<List<String>> result, List<String> tempList, String s, boolean[][] isPalindrome, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                tempList.add(s.substring(start, i + 1));
                dfs(result, tempList, s, isPalindrome, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

//         List<String> myList = s.chars().mapToObj(c -> String.valueOf((char) c)).toList();



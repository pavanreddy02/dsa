package src.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L139WordBreak {
    public static void main(String[] args) {
        String s = "leetcod ";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, wordDict));

//        for (String value : wordDict) {
//            if (s.contains(value)) {
//                if (s.length()<= value.length()){
//                    s = s.substring(s.indexOf(value), value.length());
//                }else {
//                    s = s.substring(value.length());
//                }
//                System.out.println(s);
//            } else {
//                System.out.println("failed");
//                break;
//            }
//        }
    }

    static boolean wordBreak(String input, List<String> words){
        int n = input.length();
        boolean[] dp = new boolean[n+1];
        int maxLen = 0;
        for (String word: words) {
            maxLen = Math.max(maxLen, word.length());
        }
        dp[0]= true;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j >= 0 ; j--) {
                if ((i-j) > maxLen) continue;
                if (dp[j] && words.contains(input.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

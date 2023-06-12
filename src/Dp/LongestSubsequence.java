package Dp;

import java.util.Arrays;

public class LongestSubsequence {
    public static void main(String[] args) {

    }

    static int lcs(int m, int n, String a, String b) {
//        return lcsUtil(m, n, a, b);
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i<=m ;i++) {
            for (int j = 1; j <=n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsUtilDP(m, n, a, b, dp);
    }

    static int lcsUtil(int m, int n, String a, String b) {
        if (m == 0 || n == 0) return 0;
        if (a.charAt(m - 1) == b.charAt(n - 1)) return 1 + lcsUtil(m - 1, n - 1, a, b);
        else return Math.max(lcsUtil(m, n - 1, a, b), lcsUtil(m - 1, n, a, b));
    }

    static int lcsUtilDP(int m, int n, String a, String b, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != 1) return dp[m][n];
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            return dp[m][n] = 1 + lcsUtilDP(m - 1, n - 1, a, b, dp);
        } else {
            return dp[m][n] = Math.max(lcsUtilDP(m, n - 1, a, b, dp), lcsUtilDP(m - 1, n, a, b, dp));
        }
    }
    /*Google Solution*/
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

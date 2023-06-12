package Dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int n = 18;
        int[] arr = {7, 5, 1};
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, -1);
        System.out.println(minCoins(n, arr, dp));
    }

    static int minCoins(int n, int[] arr, int[] dp) {
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int each : arr) {
            if (n - each >= 0) {
                int subAns;
                if (dp[n - each] != -1) {
                    subAns = dp[n - each];
                } else {
                    subAns = minCoins(n - each, arr, dp);
                }
                if (subAns != Integer.MAX_VALUE &&
                        subAns + 1 < ans) {
                    ans = ++subAns;
                }
            }
        }
        return dp[n] = ans;
    }
}

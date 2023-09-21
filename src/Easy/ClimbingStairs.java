package src.Easy;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
    static int climbStairs(int n) {
        int prev1 = 1; // dp[i - 1]
        int prev2 = 1; // dp[i - 2]

        for (int i = 2; i <= n; ++i) {
            int dp = prev1 + prev2;
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }
}

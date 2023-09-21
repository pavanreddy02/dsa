package Medium;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {

    }

    public static int minPlatform(int[] a, int[] d, int n) {
        Arrays.sort(a);
        Arrays.sort(d);
        int count = 0, ans = 0, i = 0, j = 0;
        while (i < n) {
            if (a[i] <= d[j]) {
                count++;
                ans = Math.max(ans, count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return ans;
    }
}

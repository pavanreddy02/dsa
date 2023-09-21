package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    public static ArrayList<Integer> maxMeetings(int n, int[] s, int[] f) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = i + 1;
            a[i][1] = s[i];
            a[i][2] = f[i];
        }
        Arrays.sort(a, Comparator.comparingInt(z -> z[2]));
        int r = a[0][2];
        ans.add(a[0][0]);
        for (int[] ints : a)
            if (ints[1] > r) {
                ans.add(ints[0]);
                r = ints[2];
            }
        Collections.sort(ans);
        return ans;
    }
}

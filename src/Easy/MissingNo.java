package Easy;

import java.util.Arrays;

public class MissingNo {
    public static void main(String[] args) {
        int[] a = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNo(a));
    }

    static int missingNo(int[] a) {
        Arrays.sort(a);
        int count = a[0];
        for (int aa : a) if (aa != count++) return --count;
        return 0;
    }
}

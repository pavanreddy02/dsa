package Easy;

import java.util.Arrays;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        int[] b = {1, 3, 12, 0, 0};
        moveZeros(a);
    }

    static void moveZeros(int[] a) {
//        List<Integer> list = new java.util.ArrayList<>(Arrays.stream(a).boxed().toList());
        System.out.println(Arrays.toString(a));
        int count = 0;
        for (int i : a) {
            if (i != 0) {
                a[count++] = i;
            }
        }
        while (count < a.length) a[count++] = 0;
        System.out.println(Arrays.toString(a));
    }
}

package Easy;

import java.util.Arrays;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeros(a);
        System.out.println(Arrays.toString(a));

    }

    static void moveZeros(int[] a) {
//        List<Integer> list = new java.util.ArrayList<>(Arrays.stream(a).boxed().toList());
        int count = 0;
        for (int i : a) {
            if (i != 0) {
                a[count++] = i;
            }
        }
        while (count < a.length) a[count++] = 0;
    }
}

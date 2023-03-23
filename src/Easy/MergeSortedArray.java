package Easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 0, 0, 0};
        int[] second = {2, 5, 6};
        int i = first.length - 1;
        int j = second.length - 1;
        int k = first.length + second.length;
//                first.length + second.length - 1;
//        Thread.currentThread().join();
        int[] rr = new int[k];
        while (k >= 0) {

            if (i >= 0 && j >= 0) {

                if (first[i] >= second[j]) {
                    rr[k--] = first[i--];
                } else {
                    rr[k--] = second[j--];
//                    k--;
                }
            } else if (j >= 0) {
                rr[k--] = second[j--];

            } else {
                break;
            }

        }
        for (int ii : rr) {
            System.out.println(ii);
        }
        System.out.println(Arrays.stream(rr).iterator());
        int[] result = mergeTwoSortedArray(first, second);
//        Arrays.stream(result).asLongStream().System.out.println();
//        for (int i = 0; i <result.length ; i++) {
        System.out.println(result[i] + ">>>>");
//            System.out.println(Arrays.stream(result).f->);
//        }
    }

    static int[] mergeTwoSortedArray(int[] first, int[] second) {
        int maxLen = first.length + second.length - 1;
        int f = first.length - 1;
        int s = second.length - 1;
        int[] result = new int[maxLen];
        for (int i = maxLen; i <= 0; i--) {
            if (f >= 0 && s >= 0) {
                if (first[f] >= second[s]) {
                    result[i] = first[f--];
                } else {
                    result[i] = second[s--];
                }
            } else if (s <= 0) {
                result[i] = second[s--];
            } else {
                break;
            }
        }
        return result;
    }
}

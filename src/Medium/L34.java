package src.Medium;

import java.util.Arrays;

public class L34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] arr = new int[5000];
        Arrays.fill(arr, 8);
        for (int i = 4990; i < arr.length; i++) {
            arr[i] = 9;
        }
        long start = System.currentTimeMillis();
        Arrays.stream(searchRange(arr, 9)).forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start+" fro normal");
        start = System.currentTimeMillis();
        Arrays.stream(searchRange1(arr, 9)).forEach(System.out::println);
        System.out.println( (System.currentTimeMillis() - start)+ "  for binary" );
    }

    static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target) {
                if (start == -1) start = i;
                end = i;
            }
        return new int[]{start, end};
    }

    static int[] searchRange1(int[] nums, int target) {
        final int l = firstGreaterEqual(nums, target);
        if (l == nums.length || nums[l] != target)
            return new int[]{-1, -1};
        final int r = firstGreaterEqual(nums, target + 1) - 1;
        return new int[]{l, r};
    }

    static int firstGreaterEqual(int[] A, int target) {
        int l = 0;
        int r = A.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if (A[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

}

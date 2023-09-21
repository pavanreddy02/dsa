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

    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumberBinary(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}

package Medium;

import java.util.TreeSet;

public class L_53_Max_SubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray1(int[] nums, int k) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum-k, max);
            if (sum < 0) sum = 0;
        }
        return max;
    }


    int maxSubArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            Integer ceilValue = set.ceiling(currSum - k);
            if(ceilValue != null) {
                max = Math.max(max, currSum - ceilValue);
            }
            set.add(currSum);
        }
        return max;
    }
}

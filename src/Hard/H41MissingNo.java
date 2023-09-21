package Hard;

import Util.DsaUtility;

public class H41MissingNo {
    public static void main(String[] args) {
        int[] input ={3,4,-1,1};
        System.out.println(firstMissingPositive(input));
    }

   /* public static int firstMissingPositive(int[] nums) {
        int small = 1;
        int nextSmall = 1;
        int nextNextSmall = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) {
                small = Math.min(small, num);
            }
            if (num == (small + 1)) {
                nextSmall = num;
            }
            if (num > small && num < max) {
                nextNextSmall = num;
            }
            max = Math.max(max, num);
        }
        if (nextSmall > 1) {
            return nextSmall;
        }
        return nums.length + 1;
    }

    */
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        int j;
        int n = nums.length;

        // handle case of a single-element array
        if (n == 1) {
            if (nums[i] == 1) return 2;
            else return 1;
        }

        // try to place numbers in their correct indices
        while (i < n) {
            // ignore numbers out of range (negative numbers and numbers greater than length of the array)
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                DsaUtility.swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        // loop through the array again
        // find the first number that is not at its correct index
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}

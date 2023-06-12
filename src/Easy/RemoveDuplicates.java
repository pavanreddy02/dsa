package Easy;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Arrays.stream(nums).forEach(System.out::println);
        removeDuplicates(nums);
        System.out.println("----------------------------------");
        Arrays.stream(nums).forEach(System.out::println);
    }

    static int removeDuplicates(int[] nums) {
        int unique = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 1 || nums[i] > nums[i-1]) {
                nums[unique++] = nums[i];
            }
        }
        return unique;
    }

    static int removeDuplicates1(int[] nums) {
        int unique = 0;
        for (int num : nums) if (unique < 1 || num > nums[unique - 1]) nums[unique++] = num;
        return unique;
    }
}

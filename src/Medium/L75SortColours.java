package Medium;


import Util.DsaUtility;

import java.util.Arrays;

public class L75SortColours {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }

    public static void sortColors(int[] nums) {
        int l = 0;               // Next 0 should be put in l
        int r = nums.length - 1; // Next 2 should be put in r

        for (int i = 0; i <= r;)
            if (nums[i] == 0)
                DsaUtility.swapExR(nums, i++, l++);
            else if (nums[i] == 1)
                ++i;
            else
                // We may swap a 0 to index i, but we're still not sure whether
                // this 0 is put in the correct index, so we can't move pointer i
                DsaUtility.swapExR(nums, i, r--);
    }
}

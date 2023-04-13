package src.Medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class L46_Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> inner = new LinkedHashSet<>();
            inner.add(nums[i]);
            for (int j = 0; j < nums.length; j++) {
                inner.add(nums[j]);
            }
            ans.add(inner.stream().toList());
            Set<Integer> inner2 = new LinkedHashSet<>();
            inner2.add(nums[i]);
            for (int j = nums.length-1 ; j >= 0; j--) {
                inner2.add(nums[j]);
            }
            ans.add(inner2.stream().toList());
        }
        System.out.println(ans);
        return ans;
    }
}

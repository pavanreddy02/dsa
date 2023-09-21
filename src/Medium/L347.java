package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }

    static Set<Integer> topKFrequent(int[] nums, int k) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            long numOfOnes = Arrays.stream(nums).filter(num -> num == nums[finalI]).count();
            if (numOfOnes >= k) ans.add(nums[i]);
        }
        return ans;
    }
}

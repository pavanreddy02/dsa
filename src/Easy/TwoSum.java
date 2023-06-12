package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.stream;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        stream(twoSum1(nums, 6)).forEach(System.out::println);
    }

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> intVsPlace = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (intVsPlace.containsKey(target - nums[i])){
                return new int[]{intVsPlace.get(target - nums[i]), i};
            }
            intVsPlace.put(nums[i], i);
        }
        return new int[]{};
    }
}

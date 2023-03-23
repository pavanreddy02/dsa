package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L178 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
        final String s = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));
        System.out.println(s);
    }

    static StringBuilder largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10) {
                inputs.add(nums[i]);
                continue;
            }
            int temp = nums[i];
            while (temp > 0) {
                inputs.add(temp % 10);
                temp = temp / 10;
            }
        }
        inputs.sort(Collections.reverseOrder());
        inputs.forEach(ans::append);
        return ans;
    }
}

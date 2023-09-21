package Medium;

import java.util.Arrays;

public class L81SearchInRotatedArray {
    public boolean search(int[] nums, int target) {
        return Arrays.stream(nums).parallel().anyMatch(num -> num == target);
    }
}

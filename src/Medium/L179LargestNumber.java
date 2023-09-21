package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class L179LargestNumber {
    public static void main(String[] args) {
        int[] nums = {10,2};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        final String s = Arrays.stream(nums).parallel()
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));
        return s.startsWith("00") ? "0" : s;
    }
}

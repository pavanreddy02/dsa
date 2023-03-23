package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        long start = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(singleNumberBitManipulation(nums));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(singleNumber(nums));
        System.out.println(System.currentTimeMillis() - start);

    }

    static int singleNumber(int[] input) {
        int unique = 0;
        List<Integer> li = Arrays.stream(input).boxed().collect(Collectors.toList());
        for (int j : input) {
            li.remove(Integer.valueOf(j));
            if (!li.contains(j)) {
                return j;
            }
        }
        return unique;
    }

    static int singleNumberBitManipulation(int[] input) {
        int ans = 0;
        for (int a : input) {
            ans ^= a;
        }
        return ans;
    }
}

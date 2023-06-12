package Easy;

import java.util.*;

import static java.lang.System.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] input = {1,1};
        Set<Integer> s = new HashSet<>();

        for (int i: input)
            if (!s.add(i)) {
                out.println("ContainsDuplicate");
                return;
            }
        out.println("Does not ContainsDuplicate");
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums).anyMatch(i -> !set.add(i));
    }
}

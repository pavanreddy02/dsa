package Easy;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        System.out.println(intersectTwoArray(a, b));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums1)
            count.put(num, count.getOrDefault(num, 0) + 1);

        for (final int num : nums2)
            if (count.containsKey(num) && count.get(num) > 0) {
                ans.add(num);
                count.put(num, count.get(num) - 1);
            }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static List<Integer> intersectTwoArray(int[] a, int[] b) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> al = Arrays.stream(a).parallel().boxed().collect(Collectors.toList());
        List<Integer> bl = Arrays.stream(b).boxed().collect(Collectors.toList());
        if (al.size() > bl.size()) {
            for (Integer in : al) {
                if (bl.contains(in)) {
                    bl.remove(in);
                    ans.add(in);
                }
            }
        } else {
            for (Integer in : bl) {
                if (al.contains(in)) {
                    al.remove(in);
                    ans.add(in);
                }
            }
        }

        return ans;
    }
}

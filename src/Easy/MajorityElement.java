package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] input) {
        Integer ans = null;
        int count = 0;

        for (final int num : input) {
            if (count == 0) ans = num;
            count += (num == ans) ? 1 : -1;
        }

        return ans;
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int t : nums){
            map.put(t, map.getOrDefault(t, 0)+1);
            if (map.containsKey(t) && map.get(t) > nums.length/2)
                return t;
        }
        return -1;
//        int max = Integer.MIN_VALUE;
//        int maxKey =0;
//        for (Map.Entry e: map.entrySet()) {
//            if((Integer) e.getValue() >= max){
//                max = (int) e.getValue();
//                maxKey = (int) e.getKey();
//            }
//        }
//        return maxKey;
    }

    public int majorityElement11(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}

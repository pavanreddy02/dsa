package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L454_4sum_2 {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        /*
        for loop replaced by stream
        * */
        Arrays.stream(nums3).forEach(k -> Arrays.stream(nums4).
                forEach(l -> map.put(k + l, map.getOrDefault(k + l, 0) + 1)));
        for(int i : nums1){
            for(int j : nums2){
                count += map.getOrDefault(-(i+j), 0);
            }
        }
//        count += Arrays.stream(nums1).map(i -> Arrays.stream(nums2).map(j -> map.getOrDefault(-(i + j), 0)).sum()).sum();
        return count;
    }
    /*
    below code will not work it will give a timeout
    * */
    public int fourSumCountBrrotForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        int n = nums1.length;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                for(int k = 0; k<n;k++){
                    for(int l = 0; l<n;l++){
                        if(nums1[i] + nums2[j]+nums3[k]+nums4[l] == 0) count++;
                    }
                }
            }
        }
        return count;
    }
}

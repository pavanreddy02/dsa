package Medium;

import java.util.*;

public class L128LongestSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        int max = 0;

        //so we will be checking for every n+1 and n-1 elements for current element

        for(int i : nums){
            //check if that number contains or not cause it can get removed by the operations
            if(set.contains(i)){

                //check for the left Consecutive
                int left = i-1;
                //check for the right Consecutive
                int right = i+1;

                //check for the further  left Consecutive
                while(set.contains(left)){
                    set.remove(left);
                    left--;
                }

                //check for the further  right Consecutive
                while(set.contains(right)){
                    set.remove(right);
                    right++;
                }

                max = Math.max(max,right - left -1);
                set.remove(i);
            }

        }


        return max;
    }
}

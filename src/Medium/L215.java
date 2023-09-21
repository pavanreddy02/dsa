package Medium;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class L215 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        int[] nums ={-1, -1};
        System.out.println(findKthLargest(nums, 2));
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i =0;
        while (i < k){
            pq.add(nums[i]);
            i++;
        }
        for (int j = k; j <nums.length ; j++) {
            if(pq.peek() < nums[j]){
                pq.poll();
                pq.add(nums[j]);
            }
        }
        return pq.peek();
    }

    public static int findKthLargest1(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int each: nums){
            if(Integer.signum(each) >=0){
                map.put(each, map.getOrDefault(each,0)+1);
            }else {
                map.put(each, map.getOrDefault(each,0)-1);
            }

        }
        int count =1;
        if (map.entrySet().size() <= 2){
            return nums[k-1];
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (count ==  k) {
                return entry.getKey();
            }
            if(Integer.signum(entry.getValue()) >=0){
                count += entry.getValue();
            }else {
                count -= entry.getValue();
            }
        }
        return 0;
    }
}

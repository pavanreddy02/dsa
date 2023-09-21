package Medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class L46_Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findAllCombinations(ans, nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    static void findAllCombinations(List<List<Integer>> res, int[] nums, ArrayList<Integer> curr, boolean[] visited){
        if (curr.size() == visited.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            curr.add(nums[i]);
            findAllCombinations(res, nums, curr, visited);
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}

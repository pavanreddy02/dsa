package Easy;

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
}

package Medium;

public class L162PeakEle {
    public static void main(String[] args) {
        int[] input ={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(input));
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // single element
        // check if 0th/n-1th index is the peak element
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static int findPeakElementBinary(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // single element
        // check if 0th/n-1th index is the peak element
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        // search in the remaining array
        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
        return -1;
    }
}

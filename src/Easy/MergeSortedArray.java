package Easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 0, 0, 0};
        int[] second = {2, 5, 6};
        merge2(first, first.length, second, second.length);
        Arrays.stream(first).forEach(System.out::println);
    }
    /*gives out of bound exception  */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        while (m > i && n > i) {
            if (nums1[i] <= nums2[j]) {
                result[i] = nums1[i++];
                m--;
            } else {
                result[i] = nums2[j++];
                n--;
            }
        }
        while (m > 0) {
            if (nums1[i] > result[i]) {
                result[i + 1] = nums1[i++];
            }
            m--;
        }
        while (n > 0) {
            result[i + 1] = nums2[j++];
            i++;
            n--;
        }
        Arrays.stream(result).forEach(k -> System.out.println(k + " :"));
    }

    static void merge2(int[] first, int m, int[] second, int n) {
        int i = 3 - 1;
        int j = n - 1;
        int k = 3 + n - 1;
        while (j >= 0) {
            if (i >= 0 && first[i] > second[j])
                first[k--] = first[i--];
            else
                first[k--] = second[j--];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;     // nums1's index (actual nums)
        int j = n - 1;     // nums2's index
        int k = m + n - 1; // nums1's index (next filled position)

        while (j >= 0)
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
    }
}

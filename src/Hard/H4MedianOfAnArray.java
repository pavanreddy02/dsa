package Hard;


import Util.DsaUtility;

public class H4MedianOfAnArray {
    public static void main(String[] args) {
        int[] a ={};
        int[] b ={2,3};
        findMedianSortedArrays(a, b);
    }

    public static double wr(int[]a, int[]b){
        int total = a.length + b.length;
        int mid = total /2;
        int[] merged = DsaUtility.mergedArray(a, b, mid);
        if(total % 2 != 0){
            return (double) merged[mid];
        }else {
            return ((double) merged[mid] + merged[mid-1])/2;
        }
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int reached1 =0;
        int reached2 =0;
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; reached1 < nums1.length && reached2 < nums2.length; i++) {
            if (nums1[reached1] <= nums2[reached2]){
                arr[i] = nums1[reached1];
                reached1++;
            }else {
                arr[i] = nums2[reached2];
                reached2++;
            }
        }
        while (reached1 < nums1.length){
            arr[reached1+reached2] = nums1[reached1];
            reached1++;
        }
        while (reached2 < nums2.length){
            arr[reached2+reached1] = nums2[reached2];
            reached2++;
        }
        int total = nums1.length + nums2.length;
        int mid = total/2;
        if(total % 2 !=0){
            return arr[mid];
        }else{
            return ((double)arr[mid] + arr[mid-1])/2;
        }
    }

    public double findMedianSortedArraysFast(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] new_arr = new int[n];

        int i=0, j=0, k=0;

        while (i<=n1 && j<=n2) {
            if (i == n1) {
                while(j<n2) new_arr[k++] = nums2[j++];
                break;
            } else if (j == n2) {
                while (i<n1) new_arr[k++] = nums1[i++];
                break;
            }

            if (nums1[i] < nums2[j]) {
                new_arr[k++] = nums1[i++];
            } else {
                new_arr[k++] = nums2[j++];
            }
        }

        if (n%2==0) return (float)(new_arr[n/2-1] + new_arr[n/2])/2;
        else return new_arr[n/2];
    }
}

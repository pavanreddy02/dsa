package Easy;

import java.util.Arrays;

public class E_1337 {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[] ans = kWeakestRows1(mat, 3);
        Arrays.stream(ans).forEach(System.out::println);
    }

    public static int[] kWeakestRows1(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;
        //Create an array of size no. of rows present in mat
        int[] arr = new int[rows];
        for (int i = 0; i < rows; i++) {
            int count1 = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    count1++;
                }
            }
            arr[i] = count1;
        }

        int[] ans = new int[k];//Create ans array of size k
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            ans[i] = minIndex;
            arr[minIndex] = Integer.MAX_VALUE;
        }

        return ans;
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        int[] ans = new int[mat.length];
        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 1) break;
                count++;
            }
            ans[i] = count;
        }
        Arrays.sort(ans);
        int[] ansFinal = new int[k];
        System.arraycopy(ans, 0, ansFinal, 0, k);
        return ansFinal;
    }
}

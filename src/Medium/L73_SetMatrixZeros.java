package Medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class L73_SetMatrixZeros {
    public static void main(String[] args) {
        System.out.println();
    }
    public void setZeroes(int[][] matrix) {
        int m =matrix.length;
        int n =matrix[0].length;
        int[][] ans = new int[matrix.length][matrix[0].length];
        IntStream.range(0, m).forEach(i -> System.arraycopy(matrix[i], 0, ans[i], 0, n));
        for(int i =0; i < matrix.length;i++){
            for(int j =0; j < matrix[i].length;j++){
                if(matrix[i][j] ==0){
                    System.out.println(i + "  , " + j);
                    setZero(i ,j, ans);
                }
            }
        }
        IntStream.range(0, m).forEach(i -> System.arraycopy(ans[i], 0, matrix[i], 0, n));
    }
    public void setZero (int i ,int j, int[][] matrix){
        for(int k=0;k<matrix.length;k++){
            matrix[k][j] = 0;
        }
        for(int k=0;k<matrix[i].length;k++){
            matrix[i][k] = 0;
        }
    }

    public void setZeroes1(int[][] matrix){

        int m=matrix.length, n=matrix[0].length;
        int[] rowsArray = new int[m];
        int[] colsArray = new int[n];

        Arrays.fill(rowsArray,1);
        Arrays.fill(colsArray,1);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowsArray[i]=0;
                    colsArray[j]=0;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowsArray[i]==0 || colsArray[j]==0)
                    matrix[i][j]=0;
            }
        }
    }

    public void setZeroes2(int[][] matrix){

        int m=matrix.length, n=matrix[0].length;
        boolean isRow0=false, isCol0=false;

        for(int j=0;j<n;j++){
            if (matrix[0][j] == 0) {
                isRow0 = true;
                break;
            }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                isCol0 = true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }

        if(isRow0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if(isCol0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
    }
}

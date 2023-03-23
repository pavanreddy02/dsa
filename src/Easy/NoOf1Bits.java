package Easy;

import java.util.Scanner;

public class NoOf1Bits {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the no:  ");
//        String str = scanner.nextLine();
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '1') count++;
//        }
//        System.out.println(count);
        System.out.println(hammingWeight(11));
    }

    static int hammingWeight(int n){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((n >>2 & 1) == 1) ans++;
        }
        return ans;
    }
}

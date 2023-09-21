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
        int count=0;
        while(n!=0){
            int last_bit= n & 1; //Stores the value of the last bit of the number n i.e.(1 or 0)
            count+= last_bit; // adds 0 if last bit is 0 and adds 1 if last bit is 1
            n = n>>>1;  //Dropping the last bit of the binary number n
        }
        return count;
    }
}

package Easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 190;
        System.out.println(isHappy(n));
    }
    static boolean isHappyNo(int input){
        if (input < 10) return false;
        int sum = 0;
        while (input >= 10){
            int temp =0;
            temp = input % 10;
            sum += temp * temp ;
            input /= input;
        }
        if (sum == 1) return false;
        return true;
    }

    static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
            System.out.println("while   |" + n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        System.out.println("getNext |" + n);
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}

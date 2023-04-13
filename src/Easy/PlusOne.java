package src.Easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        int[] ans = plusOne(nums);
        Arrays.stream(ans).forEach(System.out::print);
    }

    static int[] plusOne(int[] digits) {
        int length = digits.length-1;
        int carry = 0;
        while (length >= 0) {
            carry = 1 + digits[length];
            if (carry < 10) {
                digits[length] = carry;
                return digits;
            } else {
                digits[length] = 0;
                carry = carry / 10;
            }
            length--;
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = carry;
        return ans;

    }

    public int[] plusOne1(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
            i--;
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}

package Medium;

import java.util.Stack;

public class L29 {
    public static void main(String[] args) {
        System.out.println(divide1(18, 3));
//        System.out.println(divide(18,3));
    }

    static int divide(int dividend, int divisor) {
        int ans = 0;
        int temp = 0;
        while (temp + divisor <= dividend) {
            temp += divisor;
            ans++;
        }
        return ans;
    }

    static int divide2(int dividend, int divisor){
        int ans = 0;
        while (dividend >= divisor) {
            int shift = 0;
            while (dividend >= (divisor << shift)){
                shift++;
            }
            shift--;
            ans += 1<<shift;
            dividend -= divisor << shift;
        }
        return ans;
    }

    /**
     *
     * @param dividend
     * @param divisor
     * @return
     */

    static int divide1(int dividend, int divisor) {
        int dd = dividend;
        int dr = divisor;
        if (dr == 0) {
            return Integer.MAX_VALUE;
        }
        if (dr == -1 && dd == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if ((dd < 0 && dr > 0) || (dd > 0 && dr < 0)) {
            flag = -1;
        }
        long ldd = Math.abs((long) dd);
        long ldr = Math.abs((long) dr);
        int result = 0;
        /**
         * divisor i.e ld2 is left shifted ( * by 2) until <= dividend
         * then the count is used to calculate the result by left shifting 1 to get the multiplication count
         * then the multiplication count is added to result
         * then the added value to result (by left shifting divisor by count times) is subtracted from the dividend
         * and update the dividend
         */
        while (ldd >= ldr) {
            int shift = 0;
            while (ldd >= (ldr << shift)) {
                shift++;
            }
            shift--;
            result += 1 << shift;
            ldd -= ldr << shift;
        }
        return result * flag;
    }
}

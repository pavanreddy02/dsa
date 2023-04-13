package src.Medium;

public class L29 {
    public static void main(String[] args) {
        System.out.println(divide2(18, 3));
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
        int temp = 0;
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

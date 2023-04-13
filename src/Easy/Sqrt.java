package src.Easy;

public class Sqrt {
    public static void main(String[] args) {
        int no = 8;
        System.out.println(mySqrt(no));
    }

    static int mySqrt(int x) {
        int temp = x;
        int count = 0;
        while (x >1){
            count++;
            x /= 2;
        }
        return temp/count;
    }
    public int mySqrt1(long x) {
        long l = 1;
        long r = x + 1;

        while (l < r) {
            final long m = (l + r) / 2;
            if (m > x/m){
                r = m;
            }else {
                l = m+1;
            }
        }

        // l: smallest number s.t. l * l > x
        return (int) l - 1;
    }
}

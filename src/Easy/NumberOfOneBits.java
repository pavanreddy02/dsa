package src.Easy;


public class NumberOfOneBits {
    public static void main(String[] args) {
        Long intt = 1111111113345234232L;
        System.out.println(hammingWeight(1111111113345234232L));
    }
    static int hammingWeight(long n) {
        int ans = 0;
        while (n>0){
            if (n % 10 == 1) ans++;
            n /= 10;
        }

        for (int i = 0; i < 32; ++i)
            if (((n >> i) & 1) == 1)
                ++ans;
        return ans;
    }

    static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

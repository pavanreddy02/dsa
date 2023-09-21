package Medium;

public class L204CountPrime {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
//        int ans = 0;
//        for (int i = 1; i < n; i++) {
//            if(DsaUtility.isPrime(i)) ans++;
//        }
//        return ans;
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    isPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}

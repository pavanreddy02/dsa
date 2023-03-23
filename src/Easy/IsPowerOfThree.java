package Easy;

public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(-1));

    }
    static boolean isPowerOfThree(int n){
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}

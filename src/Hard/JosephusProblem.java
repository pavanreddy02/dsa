package Hard;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(josSola(5, 3));
    }

    public static int josSol(int n, int k) {
        if (n == 1) return 1;
        return (josSol(n - 1, k) + k - 1) % n + 1;
    }

    public static int josSola(int n, int k) {
        if (n == 1) return 0;
        return (josSola(n - 1, k) + k) % n ;
    }
}

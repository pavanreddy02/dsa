package Medium;

public class L11 {
    public static void main(String[] args) {
        System.out.println(maxWater(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    static int maxWater(int[] a) {
        int max = 0;
        int tempMaxL = 0, tempMaxR = a.length - 1;
        while (tempMaxL < tempMaxR) {
            int min = Math.min(a[tempMaxL], a[tempMaxR]);
            max = Math.max(max, min * (tempMaxR - tempMaxL));
            if (a[tempMaxL] < a[tempMaxR]) {
                ++tempMaxL;
            } else {
                --tempMaxR;
            }
        }
        return max;
    }
}

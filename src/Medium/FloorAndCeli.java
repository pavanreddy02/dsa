package src.Medium;

import java.util.Arrays;

public class FloorAndCeli {
    public static void main(String[] args) {
        Util.Ds.Tree<Integer> tree = new Util.Ds.Tree<>();
        int[] arr = { -10,-4,0,5,9};
        Arrays.stream(arr).forEach(tree::insert);
        System.out.println(tree.isPairPresent(2));
    }
}

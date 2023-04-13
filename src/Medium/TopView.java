package Medium;

import Util.Ds.Pair;
import Util.Ds.Tree;

import java.util.Arrays;

public class TopView {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int[] arr = { 6,2,1,3,5,4};
        Arrays.stream(arr).forEach(tree::insert);
        tree.levelOrderTraversalByQueue(true);
        System.out.println("==============================");
        tree.topView();
    }


}

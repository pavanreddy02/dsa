package src.Easy;

import java.util.Arrays;

public class MaxDepthOfTree {
    public static void main(String[] args) {
        Util.Ds.Tree<Integer> tree = new Util.Ds.Tree<>();
        int[] arr = { -10,-3,0,5,9};
        Arrays.stream(arr).forEach(tree::insert);
//        System.out.println(tree.maxDepth());
//        System.out.println(tree.height());
//        System.out.println(tree.inorderTraversal());
//        tree.delete(9);
//        System.out.println(tree.inorderTraversal());
        System.out.println(tree.isBST(false));

    }
}

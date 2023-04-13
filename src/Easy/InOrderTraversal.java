package src.Easy;

import Util.Ds.Tree;

import java.util.Arrays;
import java.util.List;

public class InOrderTraversal {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int[] arr = { 4,2,10,99,5,6,7};
        Arrays.stream(arr).forEach(tree::insert);
        List<Integer> ans = tree.inorderTraversal();
        System.out.println(ans);
    }
}

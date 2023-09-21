package src.Easy;

import Util.Ds.Tree;

import java.util.Arrays;

public class SymmetricTree {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int[] arr = { -10,-3,0,5,9};
        Arrays.stream(arr).forEach(tree::insert);
        System.out.println(tree.isSymmetric());
    }
}

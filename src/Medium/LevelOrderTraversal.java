package Medium;

import Util.Ds.Tree;

import java.util.Arrays;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int[] arr = { 4,2,10,99,5,6,7};
        Arrays.stream(arr).forEach(tree::insert);
//        tree.preOrderTraversal();
//        System.out.println("===================");
//        levelOrderTraversal(tree);
        tree.levelOrderTraversalByQueue(true);
        System.out.println("===================");
//        tree.leftView();
        tree.printRightView();
    }

    public static void levelOrderTraversal(Tree<Integer> tree) {
        for (int i = 1; i <= tree.height(); i++) {
            tree.printCurrentLevel(i);
        }
    }

    static void levelOrderTraversalUsingQueue(Tree<Integer> tree) {
        tree.printCurrentLevel(3);
    }
}

package src.Easy;


import Util.Ds.Tree;

import java.util.Arrays;

public class TreeInOrderTraversal {
    public static void main(String[] args) {
        Tree<Integer> t2 = new Tree<>() ;
        System.out.println(t2.size());
        int[] arr = { 1, 2, 3, 4, 5 };
        Arrays.stream(arr).forEach(t2::newInsert);
//        t2.newInsert(998);
//        t2.postOrderTraversal();
//        System.out.println(t2.size());
//        System.out.println(t2.max());
        System.out.println(t2.contains(13));
    }
}

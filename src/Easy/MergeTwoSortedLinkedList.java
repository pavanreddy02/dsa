package src.Easy;

import Util.Ds.LinkedList;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> iList = new LinkedList<>();
        iList.addNode(1);
        iList.addNode(2);
        iList.addNode(4);
        LinkedList<Integer> iList2 = new LinkedList<>();
        iList2.addNode(2);
        iList2.addNode(3);
        iList2.addNode(5);
        iList2.addNode(6);
        LinkedList<Integer> merge = new LinkedList<>();
         merge.mergeList(iList, iList2);
         merge.printValues();
    }
}

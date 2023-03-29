package Easy;

import Util.Ds.LinkedList;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> iList = new LinkedList<>();
        iList.addNode(1);
        iList.addNode(2);
        iList.addNode(4);
        LinkedList<Integer> iList2 = new LinkedList<>();
        iList2.addNode(11);
        iList2.addNode(21);
        iList2.addNode(41);
        LinkedList<Integer> iList3 = new LinkedList<>();
        System.out.println(iList3.intersectionOfLists(iList, iList2));
    }
}

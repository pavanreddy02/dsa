package Easy;

import Util.Ds.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
       LinkedList<Integer> iList = new LinkedList<>();
       iList.addNode(1);
       iList.addNode(2);
       iList.addNode(3);
//       iList.reverse();
       iList.printValues(iList);
        System.out.println("=================");
        iList.reverse(iList);
        System.out.println("=================");
        iList.printValues(iList);
    }
}

package Easy;

import Util.Ds.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> iList = new LinkedList<>();
        iList.addNode(1);
        iList.addNode(2);
        iList.addNode(1);
        System.out.println(iList.isPalindrome());
    }
}

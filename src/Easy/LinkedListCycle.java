package src.Easy;

public class LinkedListCycle {
    public static void main(String[] args) {
        Util.Ds.LinkedList<Integer> iList = new Util.Ds.LinkedList<>();
        iList.addNode(1);
        iList.addNode(2);
        iList.addNode(4);
        System.out.println(iList.hasCycle());
    }
}

package src.Medium;

public class RemoveNthNode {
    public static void main(String[] args) {
        Util.Ds.LinkedList<Integer> iList = new Util.Ds.LinkedList<>();
        iList.addNode(1);
        iList.addNode(2);
        iList.addNode(4);
        iList.printValues();
        iList.removeNthFromEnd(2);
        System.out.println("==================");
        iList.printValues();
    }
}

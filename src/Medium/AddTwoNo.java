package Medium;


import java.util.*;

public class AddTwoNo {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(9,9,9));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(9,9,9));
        Util.Ds.LinkedList<Integer> ll1 = new Util.Ds.LinkedList<>();
        l1.forEach(ll1::addNode);
        Util.Ds.LinkedList<Integer> ll2 = new Util.Ds.LinkedList<>();
        l2.forEach(ll2::addNode);
        Util.Ds.LinkedList<Integer> res = new Util.Ds.LinkedList<>();
        ll1.addTwoNoFromListNode(ll1, ll2);

//        addTwoNoFromList(l1, l2);
    }

    static void addTwoNoFromList(LinkedList<Integer> l1, LinkedList<Integer> l2){
        // TODO do it by using node
        int a = l1.size();
        int b = l2.size();
        List<Integer> res = new ArrayList<>();
        int carry  = 0;
        while (a > 0 || b > 0) {
            if (b > 0) carry += l2.get(b -1);
            if (a > 0) carry += l1.get(a -1);
            res.add( carry % 10);
            carry = carry > 10 ? carry/ 10 : 0 ;
            a--;
            b--;
        }
        if (carry > 0) res.add(carry);
        Collections.reverse(res);
        System.out.println(res);
    }
}

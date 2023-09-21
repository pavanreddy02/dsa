package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class H23MergeKSortsLists {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o-> o.val));
        ListNode answer = new ListNode();
        ListNode temp = answer;
        Arrays.stream(lists).parallel().filter(Objects::nonNull).forEach(q::add);
        while (!q.isEmpty()){
            temp.next = q.poll();
            temp = temp.next;
            if (temp.next != null) q.add(temp.next);
        }
        return answer.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

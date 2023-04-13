package Util.Ds;

import java.util.Objects;

public class LinkedList<T> {
    LinkedListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (head == null) {
            this.head = newNode;
        } else {
            LinkedListNode<T> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    public void printValues() {
        LinkedListNode<T> temp = this.head;
        if (head == null) return;
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void printValues(LinkedList<T> linkedList) {
        LinkedListNode<T> head = linkedList.head;
        if (head == null) return;
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        LinkedListNode<T> temp = linkedList.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void reverse(LinkedList<T> linkedList) {

        LinkedListNode<T> head = linkedList.head;
        LinkedListNode<T> previous = null;
        LinkedListNode<T> next = null;
        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        this.head = previous;
    }

    public LinkedListNode<T> recursiveReverse(LinkedListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<T> reversed = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    public LinkedListNode<T> recursiveReverse() {
        if (this.head == null || this.head.next == null) {
            return this.head;
        }
        LinkedListNode<T> reversed = recursiveReverse();
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    public void reverse() {
        LinkedListNode<T> prevNode = null;
        LinkedListNode<T> currentNode = this.head;
        LinkedListNode<T> nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        this.head = prevNode;
    }

    private LinkedListNode<T> reverseList(LinkedListNode<T> head) {
        LinkedListNode<T> prev = null;
        LinkedListNode<T> curr = head;

        while (curr != null) {
            LinkedListNode<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome() {
        LinkedListNode<T> fast = this.head;
        LinkedListNode<T> slow = this.head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode<T> secondHalf = recursiveReverse(slow);
        LinkedListNode<T> firstHalf = this.head;
        while (secondHalf != null) {
            if (secondHalf.data != firstHalf.data) return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        return true;
    }

    // correct the below method
    public Object intersectionOfLists(LinkedList<Integer> l1, LinkedList<Integer> l2){
        LinkedListNode<Integer> a = l1.head;
        LinkedListNode<Integer> b = l2.head;

        while (!a.equals(b)) {
            a = a == null ? a : a.next;
            b = b == null ? b : b.next;
        }

        return a.data;
    }

    public void mergeList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedListNode<Integer> head1 = l1.head;
        LinkedListNode<Integer> head2 = l2.head;
        LinkedList<Integer> result = new LinkedList<>();
        while (head1 != null && head2 != null) {
            if ( head1.data <= head2.data) {
                result.addNode(head1.data);
                head1 = head1.next;
            } else {
                result.addNode(head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            result.addNode(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            result.addNode(head2.data);
            head2 = head2.next;
        }
       this.head = (LinkedListNode<T>) result.head;
    }

    public LinkedListNode<Integer> addTwoNoFromListNode(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedListNode<Integer> n1 = l1.head;
        LinkedListNode<Integer> n2 = l2.head;
        LinkedListNode<Integer> res = new LinkedListNode<>(0);
        int carry = 0;
        while (n1 != null || n2 != null) {
            if (n2 != null) {
                carry = carry + n2.data;
                n2 = n2.next;
            }
            if (n1 != null) {
                carry = carry + n1.data;
                n1 = n1.next;
            }
            // check if value to passed is carry or carry % 10
            LinkedListNode<Integer> temp = new LinkedListNode<>(carry);
            res.next = temp;
            carry = carry > 10 ? carry / 10 : 0;
        }
        if (carry > 0 ) res.next = new LinkedListNode<>(carry);
        return res.next;
    }

    public boolean hasCycle(){
        LinkedListNode<T> fast= this.head;
        LinkedListNode<T> slow= this.head;
        while (fast.next!= null && slow!= null){
            slow= slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public void remove(int index){
        if (index == 0){
            this.head = head.next;
        }else if (index == 1){
            this.head.next = this.head.next.next;
        }else {
            removeHelper(this.head, index);
        }
    }

    public void insert(int index, T value){
        insertHelper(new LinkedListNode<>(value), index);
    }

    private void insertHelper(LinkedListNode<T> newNode, int index){
        if (index == 0){
            newNode.next= this.head;
            this.head = newNode;
            return;
        }
        LinkedListNode<T> prev = this.head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    private void removeHelperOpt(int index){
        LinkedListNode<T> prev = this.head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
    private void removeHelper(LinkedListNode<T> head, int index){
        LinkedListNode<T> temp = this.head;
        int count = 0;
        while (temp != null){
            if (count == index-1){
                temp.next = temp.next.next;
                count++;
                break;
            }else {
                temp = temp.next;
                count++;
            }
        }
        if (count < index){
            throw new ArrayIndexOutOfBoundsException("Out Of Bound index:"+ index);
        }
    }

    public void removeNthFromEnd(int index){
        this.head= removeNthFromEnd(this.head, index);
    }
    private LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (n-- > 0)
            fast = fast.next;
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList<?> that)) return false;
        return head.equals(that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}

class LinkedListNode<T> {
    LinkedListNode<T> next;
    T data;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListNode<?> that)) return false;
        return Objects.equals(next, that.next) && data.equals(that.data);
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, data);
    }
}

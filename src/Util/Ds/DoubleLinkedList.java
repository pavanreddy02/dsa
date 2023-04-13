package src.Util.Ds;

public class DoubleLinkedList<T> {
   Node<T> head;
    public DoubleLinkedList() {
        this.head = null;
    }


    class Node<T> {
        public T val;
        Node<T> left;//previous
        Node<T> right;//next

        Node(T val) {
            this.val = val;
        }
    }
}

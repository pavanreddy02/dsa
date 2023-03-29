package Util.Ds;

import java.util.*;
import java.util.LinkedList;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
//        System.out.println(value.getClass());
//        System.out.println(value.getClass().equals(Integer.class));
        TreeNode<T> newNode = new TreeNode<>(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            if (value.getClass().equals(Integer.class)) {
                insertHelperInteger(this.root, newNode);
            } else {
                throw new RuntimeException(value.getClass() + "is not supported");
            }
        }
    }

    public boolean contains(TreeNode<T> currentNode, T value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if ((int) currentNode.value < (int) value) return contains(currentNode.leftChild, value);
        return contains(currentNode.rightChild, value);
    }

    private void insertHelperInteger(TreeNode<T> currentNode, TreeNode<T> newNode) {
        if ((int) newNode.value < (int) currentNode.value) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
            } else {
                insertHelperInteger(currentNode.leftChild, newNode);
            }
        } else {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
            } else {
                insertHelperInteger(currentNode.rightChild, newNode);
            }
        }
    }

    public void newInsert(T value) {
        insert(this.root, value);
    }

    public TreeNode<T> insert(TreeNode<T> root, T value) {
        if (root == null) return root = new TreeNode<>(value);
        if ((int) root.value > (int) value) {
            root.leftChild = insert(root.leftChild, value);
        } else if (((int) root.value < (int) value)) {
            root.rightChild = insert(root.rightChild, value);
        }
        return root;
    }

    private void iterativeInsert(TreeNode<T> root, T value) {
        TreeNode<T> newNode = new TreeNode<>(value);
        TreeNode<T> parent = null;
        TreeNode<T> cur = root;
        while (cur != null) {
            parent = cur;
            if ((int) cur.value < (int) value) {
                cur = cur.rightChild;
            } else {
                cur = cur.leftChild;
            }
        }
        if (parent == null) {
            parent = newNode;
        } else if ((int) value < (int) parent.value) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalHelper(this.root);
    }

    private void inOrderTraversalHelper(TreeNode<T> currentNode) {
        if (currentNode == null) return;
        inOrderTraversalHelper(currentNode.leftChild);
        System.out.println(currentNode.value);
        inOrderTraversalHelper(currentNode.rightChild);
    }

    public void preOrderTraversal() {
        preOrderTraversalHelper(this.root);
    }

    private void preOrderTraversalHelper(TreeNode<T> currentNode) {
        if (currentNode == null) return;
        System.out.println(currentNode.value);
        preOrderTraversalHelper(currentNode.leftChild);
        preOrderTraversalHelper(currentNode.rightChild);
    }

    public void postOrderTraversal() {
        postOrderTraversalHelper(this.root);
    }

    public int height() {
        return heightHelper(this.root);
    }

    public int min() {
        return minHelper(this.root);
    }

    private int minHelper(TreeNode<T> root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min((int) root.value, Math.min(minHelper(root.leftChild), minHelper(root.rightChild)));
    }

    public int max() {
        return this.maxHelper(this.root);
    }

    int maxHelper(TreeNode<T> root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max((int) root.value, Math.max(maxHelper(root.leftChild), maxHelper(root.rightChild)));
    }

    public int size() {
        return getSize(this.root);
    }

    public int getSize(TreeNode<T> root) {
        if (root == null) return 0;
        return 1 + getSize(root.leftChild) + getSize(root.rightChild);
    }

    private int heightHelper(TreeNode<T> currentNode) {
        if (currentNode == null) return 0;
        int leftHeight = heightHelper(currentNode.leftChild);
        int rightHeight = heightHelper(currentNode.rightChild);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private void postOrderTraversalHelper(TreeNode<T> currentNode) {
        if (currentNode == null) return;
        postOrderTraversalHelper(currentNode.leftChild);
        postOrderTraversalHelper(currentNode.rightChild);
        System.out.println(currentNode.value);
    }

    public void printCurrentLevel(int level){
        printCurrentLevelHelper(this.root, level);
    }

    void printCurrentLevelHelper(TreeNode<T> root, int level){
        if (root == null) return;
        if (level == 1) {
            System.out.println(root.value);
        }else if (level >0){
            printCurrentLevelHelper(root.leftChild, level-1);
            printCurrentLevelHelper(root.rightChild, level-1);
        }
    }

    public void levelOrderTraversalByQueue(boolean byHashMap) {
        if (byHashMap) {
            levelOrderTraversalByQueueUsingHashMap();
            return;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode<T> cur = queue.poll();
            if (cur == null) {
                if (queue.isEmpty()) return;
                queue.add(null);
                System.out.println();
                continue;
            }
            System.out.print(cur.value + " ,");
            if (cur.leftChild != null) queue.add(cur.leftChild);
            if (cur.rightChild != null) queue.add(cur.rightChild);
        }
    }

    private void levelOrderTraversalByQueueUsingHashMap() {
        Map<Integer, List<TreeNode<T>>> map = new HashMap<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        queue.add(null);
        int level = 0;

        while (!queue.isEmpty()) {
            TreeNode<T> cur = queue.poll();
            if (cur == null) {
                level++;
                if (queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
            addIntoLevelMap(map, level, cur);
            if (cur.leftChild != null) queue.add(cur.leftChild);
            if (cur.rightChild != null) queue.add(cur.rightChild);
        }


        map.forEach((key, treeNodeList) -> {
            System.out.print(key + " : ");
            treeNodeList.forEach(node -> System.out.print(node.value + " ,"));
            System.out.println();
        });
    }

    private void addIntoLevelMap(Map<Integer, List<TreeNode<T>>> map, int level, TreeNode<T> data) {

        map.computeIfAbsent(level, k -> new ArrayList<>());
        map.get(level).add(data);
    }

    public void leftView(){
        Map<Integer, List<TreeNode<T>>> map = new HashMap<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        queue.add(null);
        int level = 0;

        while (!queue.isEmpty()) {
            TreeNode<T> cur = queue.poll();
            if (cur == null) {
                level++;
                if (queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
            map.computeIfAbsent(level, k -> new ArrayList<>());
            if (map.get(level).size() == 0){
                map.get(level).add(cur);
            }
            if (cur.leftChild != null) queue.add(cur.leftChild);
            if (cur.rightChild != null) queue.add(cur.rightChild);
        }


        map.forEach((key, treeNodeList) -> {
            System.out.print(key + " : ");
            treeNodeList.forEach(node -> System.out.print(node.value + " ,"));
            System.out.println();
        });
    }

    public void rightView(){
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        queue.add(null);
        int level = 0;

        while (!queue.isEmpty()) {
            TreeNode<T> cur = queue.poll();
            if (cur == null) {
                level++;
                if (queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
            map.put(level, (Integer) cur.value);
            if (cur.leftChild != null) queue.add(cur.leftChild);
            if (cur.rightChild != null) queue.add(cur.rightChild);
        }


        map.forEach((key, value) -> {
            System.out.print(key + " : ");
            System.out.print(value + " ,");
            System.out.println();
        });
    }

    public void printLeftView(){
        Map<Integer, Integer> map = new HashMap<>();
        printLeftViewUtil(this.root ,map ,0);
        map.forEach((key, value) -> {
            System.out.print(key + " : ");
            System.out.print(value + " ,");
            System.out.println();
        });
    }

    private void printLeftViewUtil(TreeNode<T> root,Map<Integer, Integer> map, int level){
        if (root == null) return;
        map.putIfAbsent(level, (Integer) root.value);
        printLeftViewUtil(root.leftChild, map, level +1);
        printLeftViewUtil(root.rightChild, map, level +1);
    }

    public void printRightView(){
        Map<Integer, Integer> map = new HashMap<>();
        printRightViewUtil(this.root ,map ,0);
        map.forEach((key, value) -> {
            System.out.print(key + " : ");
            System.out.print(value + " ,");
            System.out.println();
        });
    }

    private void printRightViewUtil(TreeNode<T> root, Map<Integer, Integer> map, int level){
        if (root == null) return;
        map.put(level, (Integer) root.value);
        printRightViewUtil(root.leftChild, map, level +1);
        printRightViewUtil(root.rightChild, map, level +1);
//        if (list.get(level) == null) list.add(root);
//        printRightViewUtil(root.rightChild, list, level +1);
//        printRightViewUtil(root.leftChild, list, level +1);
    }

    public List<Object> topView(){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Integer, TreeNode<T>>> q = new ArrayDeque<>();
        q.add(new Pair<>(0, this.root));
        while (!q.isEmpty()){
            Pair<Integer, TreeNode<T>> cur = q.poll();
//            map.putIfAbsent(cur.getFirst(), (Integer) cur.getSecond().getValue());
            // map.put withOut if condition for bottom view
            if (!map.containsKey(cur.getFirst())){
                map.put(cur.getFirst(), (Integer) cur.getSecond().getValue());
            }

            if (cur.getSecond().leftChild != null){
                q.add(new Pair<>(cur.getFirst() - 1, cur.getSecond().leftChild));
            }

            if (cur.getSecond().rightChild != null){
                q.add(new Pair<>(cur.getFirst() + 1, cur.getSecond().rightChild));
            }

        }

        List<Object> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(value));
        System.out.println(list);
        return list;
    }

    private static class TreeNode<T> {
        private final T value;
        private TreeNode<T> leftChild;
        private TreeNode<T> rightChild;

        public TreeNode(T value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }

        public T getValue(){
            return this.value;
        }
    }
}

package Util.Ds;

import src.Util.Ds.DoubleLinkedList;
import src.Util.Ds.DoubleLinkedListNode;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListMap;

public class Tree<T> {
    static DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
    static DoubleLinkedListNode<Integer> prev = null , head =null;

    public static int ans = -1;
    private TreeNode<T> root;

    private TreeNode<T> temp;

    public Tree() {
        this.root = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// This section contains insert
    ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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
        if (root == null) return new TreeNode<>(value);
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


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// This section contains traversal
    ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void inOrderTraversal() {
        inOrderTraversalHelper(this.root, new LinkedList<>());
    }

    private LinkedList<T> inOrderTraversalHelper(TreeNode<T> currentNode, LinkedList<T> list) {
        if (currentNode == null) return list;
        inOrderTraversalHelper(currentNode.leftChild, list);
        list.add(currentNode.value);
        inOrderTraversalHelper(currentNode.rightChild, list);
        return list;
    }

    public LinkedList<T> inorderTraversal() {
        TreeNode<T> current = this.root;
        Stack<TreeNode<T>> stack = new Stack<>();
        LinkedList<T> result = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            // Push all left nodes onto the stack
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            // Visit the top node of the stack and move to its right child
            current = stack.pop();
            result.add(current.value);
            current = current.rightChild;
        }

        return  result;
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

    private void postOrderTraversalHelper(TreeNode<T> currentNode) {
        if (currentNode == null) return;
        postOrderTraversalHelper(currentNode.leftChild);
        postOrderTraversalHelper(currentNode.rightChild);
        System.out.println(currentNode.value);
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
        map.computeIfAbsent(level, k -> new ArrayList<>()).add(data);
    }

    public ArrayList<Integer> verticalOrderTraversal() {
        Queue<Util.Ds.Pair<Integer, TreeNode<T>>> q = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> levelVsValues = new WeakHashMap<>();
        q.add(new Util.Ds.Pair<Integer, TreeNode<T>>(0, this.root));
        while (!q.isEmpty()) {
            Util.Ds.Pair<Integer, TreeNode<T>> cur = q.poll();
            levelVsValues.computeIfAbsent(cur.getFirst(), k -> new ArrayList<>()).add((Integer) cur.getSecond().getValue());
            if (cur.getSecond().leftChild != null)
                q.add(new Util.Ds.Pair<Integer, TreeNode<T>>(cur.getFirst() - 1, cur.getSecond().leftChild));
            if (cur.getSecond().rightChild != null)
                q.add(new Util.Ds.Pair<Integer, TreeNode<T>>(cur.getFirst() + 1, cur.getSecond().rightChild));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> map : levelVsValues.entrySet()) {
            System.out.println(map.getKey()+": "+ map.getValue());
            ans.addAll(map.getValue());
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// This section contains utils
    ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int height() {
        return heightHelper(this.root);
    }

    private int heightHelper(TreeNode<T> currentNode) {
        if (currentNode == null) return 0;
        int leftHeight = heightHelper(currentNode.leftChild);
        int rightHeight = heightHelper(currentNode.rightChild);
//        System.out.println(leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int maxDepth(){ return maxDepthHelper(this.root); }

    private int maxDepthHelper(TreeNode<T> root){
        if (root == null) return 0;
        return 1 + Math.max(maxDepthHelper(root.leftChild), maxDepthHelper(root.rightChild));
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

    public boolean contains(int x){
        return containsHelper(this.root, x);
    }

    private boolean containsHelper(TreeNode<T> root, int x) {
        if (root == null) return false;
        if ((int) root.value == x) return true;
        if ((Integer) root.value > x) return containsHelper(root.leftChild, x);
        return containsHelper(root.rightChild, x);
    }

    public boolean contains(TreeNode<T> currentNode, T value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if ((int) currentNode.value < (int) value) return contains(currentNode.leftChild, value);
        return contains(currentNode.rightChild, value);
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

    public void delete(int key){
        deleteNodeHelper(this.root, key);
    }

    private TreeNode<T> deleteNodeHelper(TreeNode<T> root, int key) {
        if (root == null) return root;
        if (key < (int) root.value) {
            deleteNodeHelper(root.leftChild, key);
        } else if (key > (int) root.value) {
            deleteNodeHelper(root.rightChild, key);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }
            root.value = min(root.rightChild);
            root.rightChild = deleteNodeHelper(root.rightChild, (int) root.value);
        }
        return root;
    }

    private T min(TreeNode<T> root) {
        T min = root.value;
        while (root.leftChild != null) {
            min = root.leftChild.value;
            root = root.leftChild;
        }
        return min;
    }

    public boolean isBST(boolean byRange) {
        if (byRange) return isBSTRangeUtil(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isBST(this.root);
    }

    private boolean isBST(TreeNode<T> node) {
        if (node != null) {
            if (!isBST(node.leftChild)) return false;
            if (temp != null && (int) node.value <= (int) temp.value) {
                return false;
            }
            temp = node;
            return isBST(node.rightChild);
        }
        return true;
    }

    private boolean isBSTRangeUtil(TreeNode<T> root, int min, int max) {
        if (root == null) return true;
        if ((int) root.value < min || (int) root.value > max) return false;
        return (isBSTRangeUtil(root.leftChild, min, (int) root.value - 1) && isBSTRangeUtil(root.rightChild, (int) root.value + 1, max));
    }

    public int floor(int key) {
        int ans = Integer.MAX_VALUE;
        TreeNode<T> node = this.root;
        while (node != null) {
            if ((Integer) node.value == key) {
                return (Integer) node.value;
            }
            if ((Integer) node.value > key) {
                node = node.leftChild;
            } else {
                ans = (int) node.value;
                node = node.rightChild;
            }
        }
        return ans;
    }

    public boolean isPairPresent(int target){
        Set<Integer> set = new HashSet<>();
        return isPairPresentHelper(this.root, target, set);
    }

    private boolean isPairPresentHelper(TreeNode<T> node, int target, Set<Integer> set) {
        if (node == null) return false;
        if (isPairPresentHelper(root.leftChild, target, set)) {
            return true;
        }
        if (set.contains(target - (Integer) node.value)) {
            return true;
        }
        set.add((Integer) node.value);
        return isPairPresentHelper(node.rightChild, target, set);
    }

    public int ceil(int key){
        int ans = Integer.MIN_VALUE;
        TreeNode<Integer> node = (TreeNode<Integer>) this.root;
        while (node!=  null){
            if (node.value == key) return node.value;
            if (node.value > key){
                ans = node.value;
                node = node.leftChild;
            }else {
                node = node.rightChild;
            }
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// This section contains views
    ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        Queue<Util.Ds.Pair<Integer, TreeNode<T>>> q = new ArrayDeque<>();
        q.add(new Util.Ds.Pair<>(0, this.root));
        while (!q.isEmpty()){
            Util.Ds.Pair<Integer, TreeNode<T>> cur = q.poll();
//            map.putIfAbsent(cur.getFirst(), (Integer) cur.getSecond().getValue());
            // map.put withOut if condition for bottom view
            if (!map.containsKey(cur.getFirst())){
                map.put(cur.getFirst(), (Integer) cur.getSecond().getValue());
            }

            if (cur.getSecond().leftChild != null){
                q.add(new Util.Ds.Pair<>(cur.getFirst() - 1, cur.getSecond().leftChild));
            }

            if (cur.getSecond().rightChild != null){
                q.add(new Util.Ds.Pair<>(cur.getFirst() + 1, cur.getSecond().rightChild));
            }

        }

        List<Object> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(value));
        System.out.println(list);
        return list;
    }

    public boolean isSymmetric() {
        TreeNode<T> left = this.root.leftChild;
        TreeNode<T> right = this.root.rightChild;
        return isSymmetricHelper(left, right);
    }

    private boolean isSymmetricHelper(TreeNode<T> left, TreeNode<T> right){
        if (left == null || right == null) {return left == right;}
        return  left.value == right.value && isSymmetricHelper(left.leftChild, right.rightChild)
                && isSymmetricHelper(left.rightChild, right.leftChild);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.leftChild!=null){
            if(root.rightChild==null) return false;
            stack.push(root.leftChild);
            stack.push(root.rightChild);
        }
        else if(root.rightChild!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.value!=left.value) return false;

            if(left.leftChild!=null){
                if(right.rightChild==null)   return false;
                stack.push(left.leftChild);
                stack.push(right.rightChild);
            }
            else if(right.rightChild!=null){
                return false;
            }

            if(left.rightChild!=null){
                if(right.leftChild==null)   return false;
                stack.push(left.rightChild);
                stack.push(right.leftChild);
            }
            else if(right.leftChild!=null){
                return false;
            }
        }

        return true;
    }

    public int minTimeToBurn(int target) {
        Depth depth = new Depth(-1);
        burn(this.root, target, depth);
        return ans;
    }

    private int burn(TreeNode<T> root, int target, Depth depth) {
        if (root == null) return 0;
        if ((Integer) root.value == target) {
            depth.d = 1;
            return 1;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);
        int lh = burn(root.leftChild, target, depth);
        int rh = burn(root.rightChild, target, depth);
        if (ld.d != 1) {
            ans = Math.max(ans, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        } else if (rd.d != 1) {
            ans = Math.max(rd.d + 1, lh);
            depth.d = rd.d + 1;
        }
        return Math.max(lh, rh) + 1;
    }

    static class Depth {
        int d;

        public Depth(int d) {
            this.d = d;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// This section contains miscellaneous
    ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     void convertToDLL(TreeNode<T> root){
        if (root == null) return ;
        convertToDLL(root.leftChild);
        if (prev == null) {
            head = new DoubleLinkedListNode<>((Integer) root.value);
        }else {
//            prev.l = new TreeNode<>(prev);
        }
        convertToDLL(root.rightChild);
    }

    public DoublyListNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode prev = dummy;
        helper(root, prev);
        // Connect the head and tail
        dummy.next.prev = null;
        prev.next = null;
        return dummy.next;
    }

    private TreeNode<T> lowestCommonAncestor(TreeNode<T> root, T n1 ,T n2) {
        if (root == null) return null;
        if (root.value == n1 || root.value ==n2) return root;
        TreeNode<T> left = lowestCommonAncestor(root.leftChild, n1, n2);
        TreeNode<T> right = lowestCommonAncestor(root.rightChild, n1, n2);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    public TreeNode leftCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = leftCommonAncestor(root.leftChild, p, q);
        if (left != null && left != p && left != q) {
            return left;
        }

        TreeNode right = leftCommonAncestor(root.rightChild, p, q);
        if (right != null && right != p && right != q) {
            return right;
        }

        if (left != null && right != null) {
            return root;
        } else {
            return (left != null) ? left : right;
        }
    }


    private void helper(TreeNode node, DoublyListNode prev) {
        if (node == null) {
            return;
        }
        helper(node.leftChild, prev);
        DoublyListNode curr = new DoublyListNode((Integer) node.value);
        prev.next = curr;
        curr.prev = prev;
        prev = curr;
        helper(node.rightChild, prev);
    }
    class DoublyListNode {
        int val;
        DoublyListNode prev;
        DoublyListNode next;
        public DoublyListNode(int val) {
            this.val = val;
        }
    }

    private boolean iterative(TreeNode<T> root) {
        Stack<TreeNode<T>> left = new Stack<>();
        Stack<TreeNode<T>> right = new Stack<>();
        left.push(root.leftChild);
        right.push(root.rightChild);
        while (left.size() > 0) {
            TreeNode<T> l = left.pop();
            TreeNode<T> r = right.pop();
            if (l == null && r == null) {
                continue;
            }
            if (l != null && r != null && l.value == r.value) {
                left.push(l.leftChild);
                right.push(r.rightChild);
                left.push(l.rightChild);
                right.push(r.leftChild);
                continue;
            }
            return false;
        }
        return true;
    }


    private static class TreeNode<T> {
        private T value;
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

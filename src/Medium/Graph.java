package Medium;

// Java program to print BFS traversal from a given source
// vertex. BFS(int s) traverses vertices reachable from s.

import Util.Ds.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// This class represents a directed graph using adjacency
// list representation
class Graph {
    private static int V = 0; // No. of vertices
    private static LinkedList<LinkedList<Integer>> adj = new LinkedList<>(); // Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; ++i)
            adj.add(new LinkedList<>());
    }

    // Driver method to
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

//        g.BFS(2);
        g.DFS(0);
        System.out.println(isCycle());
        topologicalSort();
    }


    static boolean isCycleForDirected() {
        boolean[] visited = new boolean[V];
        boolean[] recurion = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (directedCycle(i, adj, visited, recurion)) return true;
            }
        }
        return false;
    }

    static boolean directedCycle(int v, LinkedList<LinkedList<Integer>> adj, boolean[] visited, boolean[] recursion) {
        visited[v] = true;
        recursion[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                if (directedCycle(v, adj, visited, recursion)) return true;
            } else if (recursion[v]) {
                return true;
            }
        }
        recursion[v] = false;
        return false;
    }

    static boolean isCycle() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, adj, visited, -1)) return true;
        }
        return false;
    }

    static boolean dfs(int v, LinkedList<LinkedList<Integer>> adj, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, v)) return true;
            } else if (parent != neighbour) {
                return true;
            }
        }
        return false;
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s If a adjacent has not been visited,
            // then mark it visited and enqueue it
            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Call the recursive helper
        // function to print DFS
        // traversal
        ArrayList<Integer> ans = new ArrayList<>();
        DFSUtil(v, visited, ans);
//        System.out.println(ans);
    }

    void DFSUtil(int v, boolean[] visited, ArrayList<Integer> ans) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        for (int n : adj.get(v)) {
            if (!visited[n])
                DFSUtil(n, visited, ans);
        }
    }

    static List<Integer> topologicalSort(){
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                topoDFS(adj, i, stack, vis);
            }
        }
        return new ArrayList<>(stack);
    }

    @Deprecated
    static void topoDFS(LinkedList<LinkedList<Integer>> adj, int v, Stack<Integer> stack, boolean[] vis){
        vis[v] = true;
        for (int neighbour: adj.get(v)) {
            if (!vis[neighbour])
                topoDFS(adj, neighbour, stack, vis);
        }
        stack.push(v);
    }


    static void topoBFS() {
        int[] inDeg = new int[V];
        adj.forEach(list -> list.forEach(e -> inDeg[e]++));
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            topoBfs(adj, i, vis, ansList, inDeg);
        }
    }

    static void topoBfs(LinkedList<LinkedList<Integer>> adj, int v, boolean[] vis, ArrayList<Integer> ansList, int[] inDeg) {
        Queue<Integer> q = IntStream.range(0, v).filter(i -> inDeg[i] == 0).boxed().collect(Collectors.toCollection(LinkedList::new));
        while (!q.isEmpty()) {
            int cur = q.poll();
            ansList.add(cur);
            for (int in : adj.get(cur)) {
                if (--inDeg[in] == 0) q.add(in);
            }
        }
    }

    /*
    * calculate the minimum dist (prims's algorithm)
    * @param
    *
    * */
    static void spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparingInt(Pair::getSecond));
        q.add(new Pair<>(0, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int u = cur.getFirst();
            if (vis[u]) continue;
            ans += cur.getSecond();
            vis[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for (ArrayList<Integer> list : neighbours) {
                int vertex = list.get(0);
                int weight = list.get(1);
                if (!vis[vertex]) q.add(new Pair<>(vertex, weight));
            }

        }
        System.out.println(ans);
    }

    static void dijkstraAlgo (int s, int v, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>();
        q.add(new Pair<>(s, 0));
        int[] ans = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[s] = 0;
        while (!q.isEmpty()){
            Pair<Integer, Integer> cur = q.poll();
            int u = cur.getFirst();
            if (vis[u]) continue;
            vis[u] = true;
            ArrayList<ArrayList<Integer>> neighbour = adj.get(u);
            neighbour.stream().parallel().forEach(list -> {
                int vertex = list.get(0);
                int weight = list.get(1);
                if (ans[vertex] > ans[u] + weight) {
                    ans[vertex] = ans[u] + weight;
                    q.add(new Pair<>(vertex, ans[vertex]));
                }
            });
        }
        Arrays.stream(ans).boxed().forEach(System.out::println);
    }

    /*
    void primMST() {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int[] key = new int[V];
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(V, Comparator.comparingInt(Pair::getSecond));
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;
        queue.add(new Pair<>(0, 0));
        List<List<Pair<Integer, Integer>>> adj1 = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll().getFirst();
            visited[u] = true;

            for (Pair<Integer, Integer> edge : adj1.get(u)) {
                int v = edge.getFirst();
                int weight = edge.getSecond();

                if (!visited[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                    queue.add(new Pair<>(v, weight));
                }
            }
        }

        System.out.println("Edges in the MST:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
     */

    public int bellmanFordCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                int weight = edge[2];
                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                return 1;
            }
        }
        return 0;
    }
}


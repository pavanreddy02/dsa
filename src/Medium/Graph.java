package src.Medium;

// Java program to print BFS traversal from a given source
// vertex. BFS(int s) traverses vertices reachable from s.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
}
// This code is contributed by Aakash Hasija


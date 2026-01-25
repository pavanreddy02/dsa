
import java.util.*;

public class Graph {
    public static void main(String[] args) {
        int v = 7;
        int e = 10;
        int [][] adj = new int[v+1][v+1];
        ArrayList<LinkedList<Integer>> adjList = getSampleAdjList();
        bfs(1, adjList, v);
    }

    static void addEdge(int u, int v, int [][] adj) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    static void addEdgeList(int u, int v, ArrayList<LinkedList<Integer>> adjList) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    // bfs
    static void bfs(int start, ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v + 1]; // To keep track of visited nodes
        LinkedList<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Mark the starting node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            int current = queue.poll();
            System.out.print(current + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
/*    static List<Integer> bfs (int start, ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] vis = new boolean[v+1];
        vis[start] = true;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int neighbour : adjList.get(curr)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return ans;
    }*/

    static <T> List<T> bfs(T start, Map<T, List<T>> adjList) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        List<T> result = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            T curr = queue.poll();
            result.add(curr);

            for (T neighbour : adjList.getOrDefault(curr, Collections.emptyList())) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }


    static int findMinDistance(int source, int destination, ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v + 1]; // To keep track of visited nodes
        int[] distance = new int[v + 1]; // To store the distance of each node from the source
        LinkedList<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Initialize the source
        visited[source] = true;
        distance[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If we reach the destination, return the distance
            if (current == destination) {
                return distance[current];
            }

            // Traverse all adjacent nodes
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1; // Update distance
                    queue.add(neighbor);
                }
            }
        }

        // If destination is not reachable, return -1
        return -1;
    }

    static int findMinDistanceWithPath(int source, int destination, ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v + 1]; // To keep track of visited nodes
        int[] distance = new int[v + 1]; // To store the distance of each node from the source
        int[] pred = new int[v + 1]; // To store the predecessor of each node
        LinkedList<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Initialize the source
        for (int i = 0; i <= v; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
            pred[i] = -1; // Initialize predecessors as -1
        }

        visited[source] = true;
        distance[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Traverse all adjacent nodes
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1; // Update distance
                    pred[neighbor] = current; // Set predecessor
                    queue.add(neighbor);

                    // If we reach the destination, return the distance
                    if (neighbor == destination) {
                        printPath(pred, source, destination); // Print the path
                        return distance[neighbor];
                    }
                }
            }
        }

        // If destination is not reachable, return -1
        return -1;
    }

    // Helper function to print the path from source to destination
    static void printPath(int[] pred, int source, int destination) {
        LinkedList<Integer> path = new LinkedList<>();
        for (int at = destination; at != -1; at = pred[at]) {
            path.addFirst(at);
        }
        System.out.print("Path: ");
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
    
    public int countConnectedComponents(ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v + 1];
        int count = 0;
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adjList);
            }
        }
        return count;
    }

    private void dfs(int u, boolean[] visited, ArrayList<LinkedList<Integer>> adjList) {
        visited[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, adjList);
            }
        }
    }

    public List<List<Integer>> findConnectedComponentsBFS(ArrayList<LinkedList<Integer>> adjList, int v) {
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                LinkedList<Integer> queue = new LinkedList<>();

                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    component.add(current);

                    for (int neighbor : adjList.get(current)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
                components.add(component);
            }
        }
        return components;
    }

    
    public static ArrayList<LinkedList<Integer>> getSampleAdjList() {
        int v = 7;
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++) {
            adjList.add(new LinkedList<>());
        }
        addEdgeList(1, 2, adjList);
        addEdgeList(2, 3, adjList);
        addEdgeList(4, 5, adjList);
        addEdgeList(6, 7, adjList);
        return adjList;
    }

    public static int[][] getSampleAdjMatrix() {
        int v = 7;
        int[][] adj = new int[v + 1][v + 1];
        addEdge(1, 2, adj);
        addEdge(2, 3, adj);
        addEdge(4, 5, adj);
        addEdge(6, 7, adj);
        return adj;
    }

    public static boolean isCycle(int source, ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] parent = new int[v + 1];

        visited[source] = true;
        queue.add(source);
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                } else if (parent[current] != neighbor) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found
    }

    // isCycle using dfs
    public static boolean isCycleDFS(int u, boolean[] visited, int parent, ArrayList<LinkedList<Integer>> adjList) {
        visited[u] = true;

        for (int neighbor : adjList.get(u)) {
            if (!visited[neighbor]) {
                if (isCycleDFS(neighbor, visited, u, adjList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle found
    }

    /**
     * Detects if a directed graph contains a cycle using Kahn's algorithm (BFS-based topological sort).
     *
     * <p>Logic and Flow:</p>
     * <ol>
     *     <li><b>Compute In-degrees:</b> Initializes an array `inDegree` to store the count of incoming edges for each vertex.
     *         It iterates through all vertices and their neighbors to populate this array.</li>
     *     <li><b>Initialize Queue:</b> A queue is populated with all vertices that have an in-degree of 0 (i.e., no incoming edges).
     *         These are the potential starting points for a topological sort.</li>
     *     <li><b>Process Vertices (BFS-like):</b> The algorithm then proceeds in a BFS-like manner:
     *         <ul>
     *             <li>Dequeue a vertex `u` from the queue.</li>
     *             <li>Increment a `count` variable, which tracks the number of vertices processed so far.</li>
     *             <li>For each neighbor `v` of `u`:
     *                 <ul>
     *                     <li>Decrement the in-degree of `v`.</li>
     *                     <li>If the in-degree of `v` becomes 0 after decrementing, it means all its prerequisite nodes
     *                         (nodes pointing to it) have been processed. Therefore, `v` is added to the queue.</li>
     *                 </ul>
     *             </li>
     *         </ul>
     *     </li>
     *     <li><b>Cycle Detection:</b> After the queue becomes empty, if the `count` of processed vertices is less than
     *         the total number of vertices (`v`), it implies that there are remaining vertices whose in-degrees never
     *         reached 0. This can only happen if these remaining vertices form a cycle, as they all have incoming edges
     *         from other nodes within that cycle, preventing them from ever being added to the queue.
     *         Therefore, if `count != v`, a cycle exists.</li>
     * </ol>
     *
     * @param adjList The adjacency list representation of the directed graph.
     * @param v The total number of vertices in the graph.
     * @return {@code true} if a cycle is detected, {@code false} otherwise.
     */
    public boolean detectCycleDirectedBFS(ArrayList<LinkedList<Integer>> adjList, int v) {
        int[] inDegree = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;

            for (int neighbor : adjList.get(u)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count != v;
    }

    // detect cycle in a directed graph using dfs
    public boolean detectCycleDirectedDFS(ArrayList<LinkedList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v + 1];
        boolean[] recursionStack = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                if (detectCycleDirectedDFSHelper(i, visited, recursionStack, adjList)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleDirectedDFSHelper(int u, boolean[] visited, boolean[] recursionStack, ArrayList<LinkedList<Integer>> adjList) {
        visited[u] = true;
        recursionStack[u] = true;

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                if (detectCycleDirectedDFSHelper(v, visited, recursionStack, adjList)) {
                    return true;
                }
            } else if (recursionStack[v]) {
                return true;
            }
        }

        recursionStack[u] = false;
        return false;
    }

}

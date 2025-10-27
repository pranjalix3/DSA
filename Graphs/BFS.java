import java.util.*;

class bfsSolution {
    // Function to return Breadth First Traversal of given graph.
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> qt = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        qt.add(0);
        visited[0] = true;
        
        while (!qt.isEmpty()) {
            int curr = qt.poll();
            bfs.add(curr);
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    qt.add(x);
                   visited[x] = true;
                }
            }
        }
        return bfs;
    }
}

public class BFS {
    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printAns(List<Integer> ans) {
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 0, 4);

        bfsSolution obj = new bfsSolution();
        List<Integer> ans = obj.bfsOfGraph(V, adj);
        printAns(ans);
    }
}
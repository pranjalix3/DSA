import java.util.*;

class Solution {
    // Function to return Depth First Traversal of given graph.
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, adj, visited, dfs);
            }
        }
        return dfs;
    }

    private void dfsUtil(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);
        for (int x : adj.get(node)) {
            if (!visited[x]) {
                dfsUtil(x, adj, visited, dfs);
            }
        }
    }
}

public class DFS {
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

        Solution obj = new Solution();
        List<Integer> ans = obj.dfsOfGraph(V, adj);
        printAns(ans);
    }
}
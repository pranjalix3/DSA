import java.util.*;
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> qt = new LinkedList<>();
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                ans++;
                qt.add(j);
            }
            while (!qt.isEmpty()) {
                int k = qt.poll();
                for (int i = 0; i < n; i++) {
                    if (isConnected[k][i] == 1) {
                        if (!visited[i]) {
                            visited[i] = true;
                            qt.add(i);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new NumberOfProvinces().findCircleNum(isConnected)); // prints 2
    }
}
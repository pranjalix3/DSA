#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution {
  public:
    vector<int>dfs;
    void dfsFind(vector<int>adj[],vector<int>vis,int V, int i){
        if(i>=V){
            return;
        }
        dfs.push_back(i);
        vis[i]=1;
        for(auto x:adj[i]){
            if(!vis[x]){
                dfsFind(adj,vis,V,x);
            }
        }
        dfs.pop_back();
    }
    vector<int> dfsOfGraph(int V, vector<int> adj[]) {
        vector<int>vis(V,0);
        dfsFind(adj,vis,V, 0);
        return dfs;
    }
};

void addEdge(vector <int> adj[], int u, int v) {
    adj[u].push_back(v);
    adj[v].push_back(u);
}

void printAns(vector <int> &ans) {
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
}

int main() 
{
    vector <int> adj[6];
    
    addEdge(adj, 0, 1);
    addEdge(adj, 1, 2);
    addEdge(adj, 1, 3);
    addEdge(adj, 0, 4);

    Solution obj;
    vector <int> ans = obj.dfsOfGraph(5, adj);
    printAns(ans);

    return 0;
}

// Output: 0 2 4 1 3 

// Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

// Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.


#include<iostream>
#include<vector>
#include<queue>
#include<stack>
using namespace std;

void edge(vector<vector<int>> &adj, int u, int v) {
  adj[u].push_back(v); 
}

//function for bfs traversal
void bfs(int s, vector<vector<int>> &adj, vector<bool> &visited) {
  queue<int> q;
  q.push(s);
  visited[s] = true;
  while (!q.empty()) {
    int u = q.front();
    cout << u << "  ";
    q.pop();

    for (int i = 0; i < adj[u].size(); i++) {
      if (!visited[adj[u][i]]) {
        q.push(adj[u][i]);
        visited[adj[u][i]] = true;
      }
    }
  }
}

//function for dfs traversal
void dfs(int s, vector<vector<int>> &adj, vector<bool> &visited) {
  stack<int> stk;
  stk.push(s);
  visited[s] = true;
  while (!stk.empty()) {
    int u = stk.top();
    cout << u << "  ";
    stk.pop();

    for (int i = 0; i<adj[u].size(); i++) {
      if (!visited[adj[u][i]]) {
        stk.push(adj[u][i]);
        visited[adj[u][i]] = true;
      }
    }
  }
}

int main() {
  int nodes = 8;
  vector<vector<int>> adj(nodes);
  vector<bool> visited(nodes, false);
  
  //input for edges
  edge(adj, 0, 1);
  edge(adj, 0, 2);
  edge(adj, 0, 7);
  edge(adj, 1, 4);
  edge(adj, 2, 3);
  edge(adj, 2, 4);
  edge(adj, 3, 5);
  edge(adj, 3, 6);
  edge(adj, 7, 6);
  
  //BFS
  cout << "BFS traversal is" << "  ";
  bfs(0, adj, visited);
  cout << endl;

  // Reset visited array
  for (int i = 0; i < nodes; i++) {
    visited[i] = false;
  }
  
  //DFS
  cout << "DFS traversal is" << "  ";
  dfs(0, adj, visited);

  return 0;
}

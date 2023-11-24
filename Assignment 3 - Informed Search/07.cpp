#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

struct Node {
    int vertex;
    int g; // Cost from the start node to this node
    int h; // Heuristic value (estimated cost from this node to the goal)
    int f; // f = g + h (total estimated cost)
    
    Node(int v, int g, int h) : vertex(v), g(g), h(h), f(g + h) {}
};

bool compareNodes(const Node& a, const Node& b) {
    return a.f < b.f;
}

vector<int> astar(vector<vector<pair<int, int>>>& graph, unordered_map<int, int>& heuristicMap, int start, int goal) {
    int numNodes = graph.size();
    vector<int> path;
    
    vector<Node> openList;
    unordered_map<int, int> gValues;
    unordered_map<int, int> parentMap;
    
    gValues[start] = 0;
    openList.push_back(Node(start, 0, heuristicMap[start]));
    
    while (!openList.empty()) {
        // Sort the nodes based on their f values
        sort(openList.begin(), openList.end(), compareNodes);
        
        Node current = openList[0];
        openList.erase(openList.begin());
        
        if (current.vertex == goal) {
            int node = goal;
            while (node != start) {
                path.push_back(node);
                node = parentMap[node];
            }
            path.push_back(start);
            reverse(path.begin(), path.end());
            return path;
        }
        
        for (const pair<int, int>& neighbor : graph[current.vertex]) {
            int neighborNode = neighbor.first;
            int cost = neighbor.second;
            int tentativeG = gValues[current.vertex] + cost;
            
            if (gValues.find(neighborNode) == gValues.end() || tentativeG < gValues[neighborNode]) {
                gValues[neighborNode] = tentativeG;
                int hValue = heuristicMap[neighborNode];
                int fValue = tentativeG + hValue;
                openList.push_back(Node(neighborNode, tentativeG, hValue));
                parentMap[neighborNode] = current.vertex;
            }
        }
    }
    
    // No path found
    return path;
}

int main() {

    int numNodes = 8;
    vector<vector<pair<int, int>>> adj(numNodes);

    adj[0] = {{1, 9}, {2, 4},{3,7}};
    adj[1] = {{0, 9}, {4, 11}};
    adj[2] = {{0, 4}, {4, 17}, {5,12}};
    adj[3] = {{0, 7},{5, 14},{6,8}};
    adj[4] = {{1,11},{2, 17}, {7, 5}};
    adj[5] = {{2, 12}, {3, 14},{7,9}};
    adj[6] = {{3,8},{7,10}};
    adj[7] = {{4,5},{5,9}};

    unordered_map<int, int> heuristicMap = {
        {0, 21},
        {1, 14},
        {2, 18},
        {3, 18},
        {4, 5},
        {5, 8},
        {6,9},
	 {7,0}
    };
    int startNode = 0;
    int goalNode = 7;
    
    vector<int> shortestPath = astar(adj, heuristicMap, startNode, goalNode);
    
    if (shortestPath.empty()) {
        cout << "No path found." << endl;
    } else {
        cout << "Shortest path from " << startNode << " to " << goalNode << ": ";
        for (int node : shortestPath) {
            cout << node << " ";
        }
        cout << endl;
    }
    
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> iPair;
struct node{
    node(int a, int b)
    {
        dest = a;
        weight = b;
    }
    int dest;
    int weight;
};
void astar(int s, int d, vector<node> v[], int visited[], int parent[], int heu[], int n)
{
    priority_queue<iPair, vector<iPair>, greater<iPair>> pq;
    pq.push(make_pair(heu[s], s));
    while (!pq.empty())
    {
        int cur = pq.top().second;
        if (cur == d)
        {
            return;
        }
        pq.pop();
        if (!visited[cur])
        {
            for (int i = 0; i < v[cur].size(); i++)
            {
                if (!visited[v[cur][i].dest])
                {
                    int f = v[cur][i].weight + heu[v[cur][i].dest];
                    pq.push(make_pair(f, v[cur][i].dest));
                    parent[v[cur][i].dest] = cur;
                }
            }
            visited[cur] = 1;
        }
    }
}

int main()
{

    int size = 7;
    vector<node> v[size];
    int no_of_edges = 9;
    v[0].push_back(node(1, 4));
    v[0].push_back(node(2, 3));
    v[1].push_back(node(3, 5));
    v[1].push_back(node(4, 12));
    v[2].push_back(node(4, 10));
    v[2].push_back(node(5, 7));
    v[3].push_back(node(6, 16));
    v[4].push_back(node(6, 5));
    v[5].push_back(node(4, 2));

    int visited[size];
    int parent[size];
    int heu[size];
    int dist[size];
    int heruristic[] = {14, 12, 11, 11, 4, 6, 0};
    for (int i = 0; i < size; i++)
    {
        heu[i] = heruristic[i];
        visited[i] = 0;
        parent[i] = i;
        dist[i] = 0;
    }
    int start = 0;
    int goal = 6;

    astar(start, goal, v, visited, parent, heu, size);
    int cur = goal;
    cout << endl;
    cout << "Path from " << start << " to " << goal << " is " << endl;
    stack<int> path;
    do
    {
        path.push(cur);
        cur = parent[cur];
    } while (cur != 0);
    path.push(start);
    while (!path.empty())
    {
        cout << path.top();
        path.pop();
        if (!path.empty())
            cout << " -> ";
    }
    return 0;
}


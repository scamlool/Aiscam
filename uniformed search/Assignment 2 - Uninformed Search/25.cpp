#include <list>
#include <iostream>

using namespace std;

class Graph {
  int numVertices;
  list<int>* adjLists;
  bool* visited;

public:
  Graph(int vertices);
  void addEdge(int src, int dest);
  void DFS(int startVertex);
  void DFSUtil(int vertex);
  void BFS(int vertex);
};

Graph::Graph(int vertices) {
  numVertices = vertices;
  adjLists = new list<int>[vertices];
}

void Graph::addEdge(int src, int dest) {
  adjLists[src].push_back(dest);
  adjLists[dest].push_back(src);
}

void Graph::DFSUtil(int vertex) {
  visited[vertex] = true;
  cout << "Visited " << vertex << "\n";

  list<int>::iterator i;
  for (i = adjLists[vertex].begin(); i != adjLists[vertex].end(); ++i) {
    int adjVertex = *i;
    if (!visited[adjVertex]) {
      DFSUtil(adjVertex);
    }
  }
}

void Graph::DFS(int startVertex) {
  visited = new bool[numVertices];
  for(int i = 0; i < numVertices; i++)
  	{
  		visited[i] = false;
	}
	

  DFSUtil(startVertex);
}

void Graph::BFS(int start){
	visited = new bool[numVertices];
	for (int i = 0; i < numVertices; i++)
    	visited[i] = false;
    list<int> queue;
    visited[start] = true;
    queue.push_back(start);

    while (!queue.empty()) {
        int currentVertex = queue.front();
        cout <<"Visited "<<currentVertex<<endl;
        queue.pop_front();

        for (int adjVertex : adjLists[currentVertex]) {
            if (!visited[adjVertex]) {
                visited[adjVertex] = true;
                queue.push_back(adjVertex);
            }
        }
    }
    	
}

int main() {
  Graph g(7);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(1, 3);
  g.addEdge(4, 5);
  g.addEdge(5, 6);
  g.addEdge(2, 3);
  g.addEdge(2, 4);
  cout<<"BFS Transversal of as follows"<<endl;
  g.BFS(2);
  cout<<"\nDFS Transversal of as follows"<<endl;
  g.DFS(2);
  return 0;
}


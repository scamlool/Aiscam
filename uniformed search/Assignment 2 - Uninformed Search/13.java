// Java program to print BFS traversal from a given source
// vertex. BFS(int s) traverses vertices reachable from s.

import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
class BFS {

	// No. of vertices
	private int V;

	// Adjacency Lists
	private LinkedList<Integer> adj[];

	// Constructor
	BFS(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) { 
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFS(int s)
    {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        stack.push(s);
        visited[s] = true;

        while(!stack.isEmpty())
        {
            int num = stack.pop();
            System.out.print(num+" ");
            for(int i=0; i<adj[num].size(); i++)
            {
                int crnt = adj[num].get(i);
                if(!visited[crnt])
                {
                    stack.push(crnt);
                    visited[crnt] = true;
                }
            }
        }
    }

	// prints BFS traversal from a given source s
	void BFSF(int s)
	{
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue
			= new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {

			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued
			// vertex s.
			// If an adjacent has not been visited,
			// then mark it visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// Driver code
	public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);

        // Taking number of nodes
        int n = sc.nextInt();

        // Taking number of edges
        int edges = sc.nextInt();
        
        // Taking start node
        int startNode = sc.nextInt();

		BFS g = new BFS(n);

        for(int i=0; i<edges; i++)
        {
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(v, w);
        }

		System.out.println(
			"Following is Breadth First Traversal "
			+ "(starting from vertex "+ startNode +")");

		g.BFSF(startNode);
        System.out.println();
        System.out.println(
			"Following is Depth First Traversal "
			+ "(starting from vertex "+ startNode +")");

		g.DFS(startNode);
	}
}

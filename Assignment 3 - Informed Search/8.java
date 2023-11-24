import java.util.*;

class Node {
    String name;
    int h;
    Map<Node, Integer> neighbours = new HashMap<>();
    
    public Node(String name,int h) {
        this.name = name;
        this.h = h;
    }
    

    public void addNeighbour(Node neighbour, int distance) {
        if (this.equals(neighbour))
            return;
        neighbours.put(neighbour, distance);
        
    }

    public int Distance(Node neighbour) {
        return neighbours.get(neighbour);
    }
}

public class aStar {
    public static List<Node> aStarSearch(Node start, Node goal) {
        Map<Node, Node> parent = new HashMap<>();
        Map<Node, Integer> gScore = new HashMap<>();
        Map<Node, Integer> fScore = new HashMap<>();

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(fScore::get));
        List<Node> closedList = new ArrayList<>();

        gScore.put(start, 0);
        fScore.put(start, start.h);
        openList.add(start);

        while (!openList.isEmpty()) {
           
            Node current = openList.poll();

            if (current.equals(goal)) {
               
                return finalPath(parent, current, gScore, fScore);
            }

            closedList.add(current);

            for (Node neighbour : current.neighbours.keySet()) {

                if (closedList.contains(neighbour))
                    continue;

                int tentativeGScore = gScore.get(current)
                        + current.Distance(neighbour);

                if (tentativeGScore < gScore.getOrDefault(neighbour, Integer.MAX_VALUE)) {
                    parent.put(neighbour, current);
                    gScore.put(neighbour, tentativeGScore);
                    fScore.put(neighbour, gScore.get(neighbour) + neighbour.h);

                    if (!openList.contains(neighbour)) {
                        openList.add(neighbour);
                    };
                }

               

            }
        }
        return Collections.emptyList();
    }

    public static List<Node> finalPath(Map<Node, Node> parent, Node current, Map<Node, Integer> gScore,
            Map<Node, Integer> fScore) {
        List<Node> path = new ArrayList<>();
        int index = 0;
        while (current != null) {
            path.add(index++, current);
            current = parent.get(current);
        }
        return path;
    }



    public static void main(String[] args) {
        Node A = new Node("A",14);
        Node B = new Node("B", 12);
        Node C = new Node("C",11);
        Node D = new Node("D", 6);
        Node E = new Node("E", 4);
        Node F = new Node("F", 11);
        Node Z = new Node("Z", 0);
        A.addNeighbour(B, 4);
        A.addNeighbour(C, 3);
        B.addNeighbour(E, 12);
        B.addNeighbour(F, 5);
        C.addNeighbour(D, 7);
        C.addNeighbour(E, 11);
        D.addNeighbour(E, 2);
        F.addNeighbour(Z, 16);
        E.addNeighbour(Z, 5);
        List<Node> li = aStarSearch(A, Z);
        for (int i = li.size() - 1; i >= 0; i--) {
            Node c = li.get(i);
            System.out.print(c.name);
            if (i > 0) {
                System.out.print("->");
            }
        }

    }
}

import java.util.*;

class Node {
    int x, y;
    int cost;
    int heuristic;
    Node parent;

    public Node(int x, int y, int cost, int heuristic, Node parent) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.heuristic = heuristic;
        this.parent = parent;
    }

    public int getTotalCost() {
        return cost + heuristic;
    }
}

public class InformedSearch {
    public static List<Node> findPath(int[][] grid, int startX, int startY, int goalX, int goalY) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::getTotalCost)); // Open set
        Map<Node, Integer> gScores = new HashMap<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Node startNode = new Node(startX, startY, 0, heuristic(startX, startY, goalX, goalY), null);

        openSet.add(startNode);
        gScores.put(startNode, 0);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.x == goalX && current.y == goalY) {
                List<Node> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = cameFrom.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (isValid(grid, newX, newY)) {
                    int tentativeGScore = gScores.get(current) + 1;
                    Node neighbor = new Node(newX, newY, tentativeGScore, heuristic(newX, newY, goalX, goalY), current);

                    if (!gScores.containsKey(neighbor) || tentativeGScore < gScores.get(neighbor)) {
                        gScores.put(neighbor, tentativeGScore);
                        cameFrom.put(neighbor, current);
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return null;
    }

    private static int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0 }
        };

        List<Node> path = findPath(grid, 0, 0, 4, 4);

        if (path != null) {
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
